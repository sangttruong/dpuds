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

public class PatientDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public PatientDAO(Connection conn, DatabaseManager dbm) {
		this.conn = conn;
		this.dbm = dbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table PATIENT ("
				 + " pid int not null,"
				 + " pname varchar(255) not null,"
				 + " age int not null,"
				 + " male boolean not null,"
				 + " address varchar(255) not null,"
				 + " phone varchar(15) not null,"
				 + " haveinsurance boolean not null,"
				 + " disease varchar(255) not null,"
				 + " primary key (pid),"
				 + " check (age >=0))";
		stmt.executeUpdate(s);
	}

	public Patient find(int id) {
		try {
			String qry = "select pname, age, male, address, phone, haveinsurance, disease from PATIENT where pid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			// return null if patient doesn't exist
			if (!rs.next()) return null;
			
			String name = rs.getString("pname");
			int age = rs.getInt("age");
			boolean male = rs.getBoolean("male");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
			boolean haveinsurance = rs.getBoolean("haveinsurance");
			String disease = rs.getString("disease");
			
			rs.close();

			Patient patient = new Patient(this, id, name, age, male, address, phone, haveinsurance, disease);
			return patient;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding the patient", e);
		}
	}

	public Patient insert(int id, String name, int age, boolean male, String address, String phone, boolean haveinsurance, String disease) {
		try {
			// make sure that the patientID is currently unused
			if (find(id) != null) return null;

			String cmd = "insert into PATIENT(pid, pname, age, male, address, phone, haveinsurance, disease) "
					   + "values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setBoolean(4, male);
			pstmt.setString(5, address);
			pstmt.setString(6, phone);
			pstmt.setBoolean(7, haveinsurance);
			pstmt.setString(8, disease);
			pstmt.executeUpdate();

			Patient patient = new Patient(this, id, name, age, male, address, phone, haveinsurance, disease);
			return patient;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting a new patient", e);
		}
	}
	
	public Collection<BItem> getBItemList(int id){
		try {
			Collection<BItem> bitemlist = new ArrayList<BItem>();
			String qry = "select sid from BITEM where pid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// Create Patient patient and Service service as input for findBillableItem()
				Patient patient = dbm.findPatient(id);
				
				int serviceid = rs.getInt("sid");
				Service service = dbm.findService(serviceid);
				
				BItem bitem = dbm.findBItem(patient, service);
				bitemlist.add(bitem);
			}
			rs.close();
			return bitemlist;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting billable item list for the patient", e);
		}
	}
	
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from PATIENT";
		stmt.executeUpdate(s);
	}
}