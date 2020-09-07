package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.depauw.csc480.model.Course;
import edu.depauw.csc480.model.Department;
import edu.depauw.csc480.model.Faculty;

/**
 * Data Access Object for the Faculty table.
 * Encapsulates all of the relevant SQL commands.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class FacultyDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public FacultyDAO(Connection conn, DatabaseManager dbm) {
		this.conn = conn;
		this.dbm = dbm;
	}

	/**
	 * Create the Faculty table via SQL
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table FACULTY("
				+ "SSN int, "
				+ "FName varchar(20) not null, "
				+ "Rank varchar(10) not null, "
				+ "DId int not null, "
				+ "primary key(SSN))";
		stmt.executeUpdate(s);
	}

	/**
	 * Modify the Faculty table to add foreign key constraints (needs to happen
	 * after the other tables have been created)
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	static void addConstraints(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "alter table FACULTY add constraint fk_facdept "
				+ "foreign key(DId) references DEPARTMENT";
		stmt.executeUpdate(s);
	}

	/**
	 * Retrieve a Faculty object given its key.
	 * 
	 * @param ssn
	 * @return the Faculty object, or null if not found
	 */
	public Faculty find(int ssn) {
		try {
			String qry = "select FName, Rank, DId from FACULTY where SSN = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, ssn);
			ResultSet rs = pstmt.executeQuery();

			// return null if faculty doesn't exist
			if (!rs.next())
				return null;

			String fname = rs.getString("FName");
			String rank = rs.getString("Rank");
			int did = rs.getInt("DId");
			rs.close();

			Department dept = dbm.findDepartment(did);
			Faculty fac = new Faculty(this, ssn, fname, rank, dept);

			return fac;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding faculty", e);
		}
	}

	/**
	 * Retrieve a Faculty object by name. Similar to find(ssn), except it
	 * searches by name.
	 * 
	 * @param fname
	 * @return the Faculty object, or null if not found
	 */
	public Faculty findByName(String fname) {
		try {
			String qry = "select SSN, Rank, DId from FACULTY where FName = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, fname);
			ResultSet rs = pstmt.executeQuery();

			// return null if faculty member doesn't exist
			if (!rs.next())
				return null;

			int ssn = rs.getInt("SSN");
			String rank = rs.getString("Rank");
			int did = rs.getInt("DId");
			rs.close();

			Department dept = dbm.findDepartment(did);
			Faculty fac = new Faculty(this, ssn, fname, rank, dept);

			return fac;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding department by name", e);
		}
	}

	/**
	 * Add a new Faculty member with the given attributes.
	 * 
	 * @param ssn
	 * @param fname
	 * @param rank
	 * @param dept
	 * @return the new Faculty object, or null if key already exists
	 */
	public Faculty insert(int ssn, String fname, String rank, Department dept) {
		try {
			// make sure that the ssn is currently unused
			if (find(ssn) != null)
				return null;

			String cmd = "insert into FACULTY(SSN, FName, Rank, DId) "
					+ "values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, ssn);
			pstmt.setString(2, fname);
			pstmt.setString(3, rank);
			pstmt.setInt(4, dept.getDeptId());
			pstmt.executeUpdate();

			Faculty faculty = new Faculty(this, ssn, fname, rank, dept);

			return faculty;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new faculty", e);
		}
	}

	/**
	 * Rank was changed in the model object, so propagate the change to the
	 * database.
	 * 
	 * @param ssn
	 * @param rank
	 */
	public void changeRank(int ssn, String rank) {
		try {
			String cmd = "update FACULTY set Rank = ? where SSN = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, rank);
			pstmt.setInt(2, ssn);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error changing rank", e);
		}
	}

	/**
	 * Department was changed in the model object, so propagate the change to
	 * the database.
	 * 
	 * @param ssn
	 * @param dept
	 */
	public void changeDept(int ssn, Department dept) {
		try {
			String cmd = "update FACULTY set DId = ? where SSN = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, dept.getDeptId());
			pstmt.setInt(2, ssn);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error changing department", e);
		}
	}

	/**
	 * Retrieve a Collection of all Courses taught by the given Faculty member.
	 * Backwards direction of FacSSN foreign key from Course.
	 * 
	 * @param ssn
	 * @return
	 */
	public Collection<Course> getCourses(int ssn) {
		try {
			Collection<Course> courses = new ArrayList<Course>();
			String qry = "select Dept, Num from COURSE where FacSSN = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, ssn);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int dept = rs.getInt("Dept");
				int num = rs.getInt("Num");
				courses.add(dbm.findCourse(dept, num));
			}
			rs.close();
			return courses;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting faculty courses", e);
		}
	}

	/**
	 * Retrieve a Collection of all Departments headed by the given Faculty
	 * member. Backwards direction of Head foreign key from Department.
	 * 
	 * @param ssn
	 * @return
	 */
	public Collection<Department> getDepartments(int ssn) {
		try {
			Collection<Department> departments = new ArrayList<Department>();
			String qry = "select DeptId from DEPARTMENT where Head = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, ssn);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int deptid = rs.getInt("DeptId");
				departments.add(dbm.findDepartment(deptid));
			}
			rs.close();
			return departments;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting faculty departments", e);
		}
	}

	/**
	 * Clear all data from the Faculty table.
	 * 
	 * @throws SQLException
	 */
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from FACULTY";
		stmt.executeUpdate(s);
	}
}
