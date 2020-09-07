package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.derby.jdbc.EmbeddedDriver;

import edu.depauw.csc480.model.BItem;
import edu.depauw.csc480.model.Doctor;
import edu.depauw.csc480.model.DoctorLab;
import edu.depauw.csc480.model.Lab;
import edu.depauw.csc480.model.Patient;
import edu.depauw.csc480.model.Room;
import edu.depauw.csc480.model.Service;

public class DatabaseManager {
	private Driver driver;
	private Connection conn;
	private BItemDAO bitemDAO;
	private DoctorDAO doctorDAO;
	private DoctorLabDAO doctorlabDAO;
	private LabDAO labDAO;
	private PatientDAO patientDAO;
	private RoomDAO roomDAO;
	private ServiceDAO serviceDAO;
	
	private final String url = "jdbc:derby:Hospital";

	public DatabaseManager() {
		driver = new EmbeddedDriver();
		
		Properties prop = new Properties();
		prop.put("create", "false");
		
		// try to connect to an existing database
		try {
			conn = driver.connect(url, prop);
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			// database doesn't exist, so try creating it
			try {
				prop.put("create", "true");
				conn = driver.connect(url, prop);
				conn.setAutoCommit(false);
				create(conn);
			} catch (SQLException e2) {
				throw new RuntimeException("cannot connect to database", e2);
			}
		}
		
		bitemDAO = new BItemDAO(conn, this);
		doctorDAO = new DoctorDAO(conn, this);
		doctorlabDAO = new DoctorLabDAO(conn, this);
		labDAO = new LabDAO(conn, this);
		patientDAO = new PatientDAO (conn, this);
		roomDAO = new RoomDAO (conn,this);
		serviceDAO = new ServiceDAO (conn, this);
	}

	private void create(Connection conn) throws SQLException {
		PatientDAO.create(conn);
		ServiceDAO.create(conn);
		BItemDAO.create(conn);
		RoomDAO.create(conn);
		DoctorDAO.create(conn);
		LabDAO.create(conn);
		DoctorLabDAO.create(conn);
		
		conn.commit();
	}

	//***************************************************************
	// Data retrieval functions -- find a model object given its key
	
	public Service findService(int id) {
		return serviceDAO.find(id);
	}

	public Patient findPatient(int id) {
		return patientDAO.find(id);
	}
	
	public Doctor findDoctor(Service service) {
		return doctorDAO.find(service);
	}
	
	public Room findRoom(Service service) {
		return roomDAO.find(service);
	}
	
	public Lab findLab(Service service) {
		return labDAO.find(service);
	}

	public DoctorLab findDoctorLab(Doctor doctor, Lab lab) {
		return doctorlabDAO.find(doctor, lab);
	}
	
	public BItem findBItem(Patient patient, Service service) {
		return bitemDAO.find(patient, service);
	}
	
	//***************************************************************
	// Data insertion functions -- create new model object from attributes
	
	public Patient insertPatient(int id, String name, int age, boolean male, String address, String phone, boolean haveinsurance, String disease) {
		return patientDAO.insert(id, name, age, male, address, phone, haveinsurance, disease);
	}

	public Doctor insertDoctor(int id, String name, int age, boolean male, String address, String phone, String expertise, Service service) {
		return doctorDAO.insert(id, name, age, male, address, phone, expertise, service);
	}

	public Service insertService(int id, double charge) {
		return serviceDAO.insert(id, charge);
	}

	public Room insertRoom(int id, String type, boolean isfull, Service service) {
		return roomDAO.insert(id, type, isfull, service);
	}
	
	public Lab insertLab(int id, String function, Service service) {
		return labDAO.insert(id, function, service);
	}
	
	public DoctorLab insertDoctorLab (Doctor doctor, Lab lab) {
		return doctorlabDAO.insert(doctor, lab);
	}
	
	public BItem insertBItem(Patient patient, Service service) {
		return bitemDAO.insert(patient, service);
	}

	//***************************************************************
	// Utility functions
	public void commit() {
		try {
			conn.commit();
		}
		catch(SQLException e) {
			throw new RuntimeException("cannot commit database", e);
		}
	}

	public void cleanup() {
		try {
			conn.rollback();
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("fatal error: cannot cleanup connection");
		}
	}

	public void close() {
		try {
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException("cannot close database connection", e);
		}
		
		// Now shutdown the embedded database system -- this is Derby-specific
		try {
			Properties prop = new Properties();
			prop.put("shutdown", "true");
			conn = driver.connect(url, prop);
		} catch (SQLException e) {
			// This is supposed to throw an exception...
			System.out.println("Derby has shut down successfully");
		}
	}

	public void clearTables() {
		try {
			patientDAO.clear();
			doctorDAO.clear();
			serviceDAO.clear();
			roomDAO.clear();
			labDAO.clear();
			doctorlabDAO.clear();
			bitemDAO.clear();
		} catch (SQLException e) {
			throw new RuntimeException("cannot clear tables", e);
		}
	}
}