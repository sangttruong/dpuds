package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import edu.depauw.csc480.model.BItem;
import edu.depauw.csc480.model.Patient;
import edu.depauw.csc480.model.Service;

public class ServiceDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public ServiceDAO(Connection pConn, DatabaseManager pDbm) {
		conn = pConn;
		dbm = pDbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table SERVICE ("
				 + " id int not null,"
				 + " charge decimal(10,2) not null,"
				 + " primary key (id),"
				 + " check (charge >= 0))";
		stmt.executeUpdate(s);
	}	
	
	public Service find(int id) {
		try {
			String qry = "select charge from SERVICE where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			// return null if Service doesn't exist
			if (!rs.next()) return null;
			double charge = rs.getDouble("charge");
			rs.close();

			Service service = new Service(this, id, charge);
			
			return service;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding a service", e);
		}
	}

	public Service insert(int id, double charge) {
		try {
			// make sure that the pServiceID is currently unused
			if (find(id) != null) return null;

			String cmd = "insert into SERVICE(id, charge)"
					   + "values(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, id);
			pstmt.setDouble(2, charge);
			pstmt.executeUpdate();

			Service service = new Service(this, id, charge);

			return service;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting a new service", e);
		}
	}

	public Collection<BItem> getBItemList(int id) {
		try {
			Collection<BItem> bitemlist = new ArrayList<BItem>();
			String qry = "select pid from BITEM where sid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("pid");
				Patient patient = dbm.findPatient(pid);
				Service service = dbm.findService(id);
				
				BItem bitem = dbm.findBItem(patient, service);
				bitemlist.add(bitem);
			}
			rs.close();
			return bitemlist;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting billable item list for a service", e);
		}
	}	
	
	public void setCharge(int id, double charge) {
		try {
			String cmd = "update SERVICE set charge = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setDouble(1, charge);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error setting the charge for a service", e);
		}		
	}
	
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from SERVICE";
		stmt.executeUpdate(s);
	}
}