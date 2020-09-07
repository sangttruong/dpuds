package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.depauw.csc480.model.Doctor;
import edu.depauw.csc480.model.Lab;
import edu.depauw.csc480.model.DoctorLab;

public class DoctorLabDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public DoctorLabDAO(Connection pConn, DatabaseManager pDbm) {
		conn = pConn;
		dbm = pDbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table DOCTORLAB ("
				 + " dsid int not null,"
				 + " lsid int not null,"
				 + " foreign key (dsid) references DOCTOR"
				 + " on delete no action,"
				 + " foreign key (lsid) references LAB"
				 + " on delete no action)";
		stmt.executeUpdate(s);
	}	
	
	public DoctorLab find(Doctor doctor, Lab lab) {
		try {
			String qry = "select * from DOCTORLAB where dsid = ? and lsid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, doctor.getService().getID());
			pstmt.setInt(2, lab.getService().getID());
			ResultSet rs = pstmt.executeQuery();

			// return null if doctor doesn't exist
			if (!rs.next())return null;
			
			rs.close();
			
			DoctorLab doctorlab = new DoctorLab(this, doctor, lab);

			return doctorlab;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding doctorlab", e);
		}
	}

	public DoctorLab insert(Doctor doctor, Lab lab) {
		try {
			// make sure that the doctor and lab is currently unused
			if (find(doctor, lab) != null)
				return null;

			String cmd = "insert into DOCTORLAB(dsid, lsid)"
					   + "values(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, doctor.getService().getID());
			pstmt.setInt(2, lab.getService().getID());
			pstmt.executeUpdate();

			DoctorLab doctorlab = new DoctorLab(this, doctor, lab);

			return doctorlab;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new doctorlab", e);
		}
	}

	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from DOCTORLAB";
		stmt.executeUpdate(s);
	}
}