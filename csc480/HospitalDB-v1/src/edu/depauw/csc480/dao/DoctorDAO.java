package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.depauw.csc480.model.Doctor;
import edu.depauw.csc480.model.Service;
import edu.depauw.csc480.model.DoctorLab;
import edu.depauw.csc480.model.Lab;

public class DoctorDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public DoctorDAO(Connection pConn, DatabaseManager pDbm) {
		conn = pConn;
		dbm = pDbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table DOCTOR ("
				 + " did int not null,"
				 + " dname varchar(255) not null," 
				 + " age int not null,"
				 + " male boolean not null,"
				 + " address varchar(255) not null,"
				 + " phone varchar(15) not null,"
				 + " expertise varchar(255) not null,"
				 + " sid int not null,"
				 + " primary key (sid),"
				 + " check (age >= 0),"
				 + " foreign key (sid) references SERVICE"
				 + " on delete no action)";
		stmt.executeUpdate(s);
	}
	
	public Doctor find(Service service) {
		try {
			String qry = "select * from DOCTOR where sid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, service.getID());
			ResultSet rs = pstmt.executeQuery();

			// return null if doctor doesn't exist
			if (!rs.next())
				return null;
			int id = rs.getInt("did");
			String name = rs.getString("dname");
			int age = rs.getInt("age");
			boolean male = rs.getBoolean("male");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
			String expertise = rs.getString("expertise");
			
			rs.close();

			Doctor doctor = new Doctor(this, id, name, age, male, address, phone, expertise, service);

			return doctor;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding doctor", e);
		}
	}

	public Doctor insert(int id, String name, int age, boolean male, String address, String phone, String expertise, Service service) {
		try {
			// make sure that the service is currently unused
			if (find(service) != null)
				return null;

			String cmd = "insert into DOCTOR(did, dname, age, male, address, phone, expertise, sid)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setBoolean(4, male);
			pstmt.setString(5, address);
			pstmt.setString(6, phone);
			pstmt.setString(7, expertise);
			pstmt.setInt(8, service.getID());
			pstmt.executeUpdate();
			
			Doctor doctor = new Doctor(this, id, name, age, male, address, phone, expertise, service);
			
			return doctor;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new doctor", e);
		}
	}

	public Collection<DoctorLab> getLabList(Service service) {
		try {
			Collection<DoctorLab> lablist = new ArrayList<DoctorLab>();
			String qry = "select lsid from DOCTORLAB where dsid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, service.getID());
			ResultSet rs = pstmt.executeQuery();
			Doctor doctor = dbm.findDoctor(service);
			while (rs.next()) {				
				int lsid = rs.getInt("lsid");
				Service lservice = dbm.findService(lsid);
				Lab lab = dbm.findLab(lservice);
				lablist.add(dbm.findDoctorLab(doctor, lab));
			}
			rs.close();
			return lablist;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting lab list of a doctor", e);
		}
	}

	public void setExpertise(Service service, String expertise) {
		try {
			String cmd = "update DOCTOR set expertise = ? where sid = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, expertise);
			pstmt.setInt(2, service.getID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error setting expertise", e);
		}
		
	}	
	
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from DOCTOR";
		stmt.executeUpdate(s);
	}
}
