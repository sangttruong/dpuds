package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.depauw.csc480.model.Patient;
import edu.depauw.csc480.model.BItem;
import edu.depauw.csc480.model.Service;

public class BItemDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public BItemDAO(Connection pConn, DatabaseManager pDbm) {
		conn = pConn;
		dbm = pDbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table BITEM (" 
				 + " pid int not null,"
				 + " sid int not null," 
				 + " foreign key (pid) references PATIENT" 
				 + " on delete no action,"
				 + " foreign key (sid) references SERVICE"
				 + " on delete no action)";
		stmt.executeUpdate(s);
	}	
	
	public BItem find(Patient patient, Service service) {
		try {
			String qry = "select * from BITEM where pid = ? and sid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, patient.getID());
			pstmt.setInt(2, service.getID());
			ResultSet rs = pstmt.executeQuery();

			// return null if billableItem doesn't exist
			if (!rs.next()) return null;
			rs.close();
			
			BItem bitem = new BItem(this, patient, service);

			return bitem;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding billable item", e);
		}
	}

	public BItem insert(Patient patient, Service service) {
		try {
			// make sure that the patient and service is currently unused
			if (find(patient, service) != null) return null;

			String cmd = "insert into BITEM(pid, sid)"
					   + " values(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, patient.getID());
			pstmt.setInt(2, service.getID());
			pstmt.executeUpdate();

			BItem bitem = new BItem(this, patient, service);

			return bitem;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new billable item", e);
		}
	}

	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from BITEM";
		stmt.executeUpdate(s);
	}
}