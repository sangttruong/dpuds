package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.depauw.csc480.model.Service;
import edu.depauw.csc480.model.Doctor;
import edu.depauw.csc480.model.DoctorLab;
import edu.depauw.csc480.model.Lab;

public class LabDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public LabDAO(Connection pConn, DatabaseManager pDbm) {
		conn = pConn;
		dbm = pDbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table LAB ("
				 + " lid int not null,"
				 + " lfunction varchar(255) not null,"
				 + " sid int not null,"
				 + " primary key (sid),"
				 + " foreign key (sid) references SERVICE"
				 + " on delete no action)";
		stmt.executeUpdate(s);
	}	
	
	public Lab find(Service service) {
		try {
			String qry = "select lid, lfunction from LAB where sid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, service.getID());
			ResultSet rs = pstmt.executeQuery();

			// return null if doctor doesn't exist
			if (!rs.next()) return null;
			int id = rs.getInt("lid");
			String function = rs.getString("lfunction");
			rs.close();
			
			Lab lab = new Lab(this, id, function, service);

			return lab;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding lab", e);
		}
	}

	public Lab insert(int id, String function, Service service) {
		try {
			// make sure that the service is currently unused
			if (find(service) != null) return null;

			String cmd = "insert into LAB(lid, lfunction, sid) "
					   + "values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, id);
			pstmt.setString(2, function);
			pstmt.setInt(3, service.getID());
			pstmt.executeUpdate();

			Lab lab = new Lab(this, id, function, service);

			return lab;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new lab", e);
		}
	}
	
	public Collection<DoctorLab> getDoctorList(Service service) {
		try {
			Collection<DoctorLab> doctorlist = new ArrayList<DoctorLab>();
			String qry = "select * from DOCTORLAB where lsid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, service.getID());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Lab lab = dbm.findLab(service);
				
				int dsid = rs.getInt("dsid");
				Service dservice = dbm.findService(dsid);				
				Doctor doctor = dbm.findDoctor(dservice);

				doctorlist.add(dbm.findDoctorLab(doctor, lab));
			}
			rs.close();
			return doctorlist;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting doctor list of a lab", e);
		}
	}	
	
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from LAB";
		stmt.executeUpdate(s);
	}
}