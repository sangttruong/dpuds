package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.jdbc.EmbeddedDriver;

import edu.depauw.csc480.model.Course;
import edu.depauw.csc480.model.Department;
import edu.depauw.csc480.model.Faculty;

/**
 * This class mediates access to the College database,
 * hiding the lower-level DAO objects from the client.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class DatabaseManager {
	private Driver driver;
	private Connection conn;
	private FacultyDAO facultyDAO;
	private DepartmentDAO departmentDAO;
	private CourseDAO courseDAO;
	
	private final String url = "jdbc:derby:CollegeDB";

	public DatabaseManager() {
		driver = new EmbeddedDriver();
		
		Properties prop = new Properties();
		prop.put("create", "false");
		
		// try to connect to an existing database
		try {
			conn = driver.connect(url, prop);
			conn.setAutoCommit(false);
		}
		catch(SQLException e) {
			// database doesn't exist, so try creating it
			try {
				prop.put("create", "true");
				conn = driver.connect(url, prop);
				conn.setAutoCommit(false);
				create(conn);
			}
			catch (SQLException e2) {
				throw new RuntimeException("cannot connect to database", e2);
			}
		}
		
		facultyDAO = new FacultyDAO(conn, this);
		departmentDAO = new DepartmentDAO(conn, this);
		courseDAO = new CourseDAO(conn, this);
	}

	/**
	 * Initialize the tables and their constraints in a newly created database
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private void create(Connection conn) throws SQLException {
		FacultyDAO.create(conn);
		DepartmentDAO.create(conn);
		CourseDAO.create(conn);
		FacultyDAO.addConstraints(conn);
		DepartmentDAO.addConstraints(conn);
		CourseDAO.addConstraints(conn);
		conn.commit();
	}

	//***************************************************************
	// Data retrieval functions -- find a model object given its key
	
	public Faculty findFaculty(int ssn) {
		return facultyDAO.find(ssn);
	}

	public Department findDepartment(int deptid) {
		return departmentDAO.find(deptid);
	}

	public Course findCourse(int dept, int num) {
		return courseDAO.find(dept, num);
	}
	
	public Faculty findFacultyByName(String fname) {
		return facultyDAO.findByName(fname);
	}
	
	public Department findDepartmentByName(String dname) {
		return departmentDAO.findByName(dname);
	}

	//***************************************************************
	// Data insertion functions -- create new model object from attributes
	
	public Faculty insertFaculty(int ssn, String fname, String rank, Department dept) {
		return facultyDAO.insert(ssn, fname, rank, dept);
	}

	public Department insertDepartment(int deptid, String dname, Faculty head) {
		return departmentDAO.insert(deptid, dname, head);
	}

	public Course insertCourse(Department dept, int num, String title, Faculty faculty) {
		return courseDAO.insert(dept, num, title, faculty);
	}

	//***************************************************************
	// Utility functions
	
	/**
	 * Commit changes since last call to commit
	 */
	public void commit() {
		try {
			conn.commit();
		}
		catch(SQLException e) {
			throw new RuntimeException("cannot commit database", e);
		}
	}

	/**
	 * Abort changes since last call to commit, then close connection
	 */
	public void cleanup() {
		try {
			conn.rollback();
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("fatal error: cannot cleanup connection");
		}
	}

	/**
	 * Close connection and shutdown database
	 */
	public void close() {
		try {
			conn.close();
		}
		catch(SQLException e) {
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

	/**
	 * Clear out all data from database (but leave empty tables)
	 */
	public void clearTables() {
		try {
			// This is not as straightforward as it may seem, because
			// of the cyclic foreign keys -- I had to play with
			// "on delete set null" and "on delete cascade" for a bit
			facultyDAO.clear();
			departmentDAO.clear();
			courseDAO.clear();
		} catch (SQLException e) {
			throw new RuntimeException("cannot clear tables", e);
		}
	}
}
