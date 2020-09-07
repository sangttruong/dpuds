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
 * Data Access Object for the Department table.
 * Encapsulates all of the relevant SQL commands.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class DepartmentDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public DepartmentDAO(Connection conn, DatabaseManager dbm) {
		this.conn = conn;
		this.dbm = dbm;
	}

	/**
	 * Create the Department table via SQL
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table DEPARTMENT("
				+ "DeptId int, "
				+ "DName varchar(20) not null, "
				+ "Head int, " // Head may be null when a dept is created
				+ "primary key(DeptId))";
		stmt.executeUpdate(s);
	}

	/**
	 * Modify the Department table to add foreign key constraints (needs to
	 * happen after the other tables have been created)
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	static void addConstraints(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "alter table DEPARTMENT add constraint fk_deptfac "
				+ "foreign key(Head) references FACULTY on delete set null";
		stmt.executeUpdate(s);
	}

	/**
	 * Retrieve a Department object given its key.
	 * 
	 * NOTE: this does not attempt to retreive the head of the department,
	 * because of the f.k. cycle between Department and Faculty (otherwise,
	 * there could be an infinite loop when fetching a Faculty object -- it
	 * needs its Department object to be created, which would first need its
	 * head's Faculty object to be created, which first needs the Department
	 * object, etc.). Instead, it stores a null for the head, and fetches it
	 * later (lazily) if needed.
	 * 
	 * @param deptid
	 * @return the Department object, or null if not found
	 */
	public Department find(int deptid) {
		try {
			String qry = "select DName from DEPARTMENT where DeptId = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, deptid);
			ResultSet rs = pstmt.executeQuery();

			// return null if department doesn't exist
			if (!rs.next())
				return null;

			String dname = rs.getString("DName");
			rs.close();

			Department dept = new Department(this, deptid, dname);

			return dept;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding department", e);
		}
	}

	/**
	 * Retrieve a Department object by name. Similar to find(deptid), except it
	 * searches by name.
	 * 
	 * @param dname
	 * @return the Department object, or null if not found
	 */
	public Department findByName(String dname) {
		try {
			String qry = "select DeptId from DEPARTMENT where DName = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, dname);
			ResultSet rs = pstmt.executeQuery();

			// return null if department doesn't exist
			if (!rs.next())
				return null;

			int deptid = rs.getInt("DeptId");
			rs.close();

			Department dept = new Department(this, deptid, dname);

			return dept;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding department by name", e);
		}
	}

	/**
	 * Add a new Department with the given attributes.
	 * 
	 * @param deptid
	 * @param dname
	 * @param head
	 *            (may be null)
	 * @return the new Department object, or null if key already exists
	 */
	public Department insert(int deptid, String dname, Faculty head) {
		try {
			// make sure that the deptid is currently unused
			if (find(deptid) != null)
				return null;

			String cmd = "insert into DEPARTMENT(DeptId, DName, Head) "
					+ "values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, deptid);
			pstmt.setString(2, dname);
			if (head != null) {
				// special handling because the head might be null
				pstmt.setInt(3, head.getSsn());
			} else {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			pstmt.executeUpdate();

			Department department = new Department(this, deptid, dname, head);

			return department;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new department", e);
		}
	}

	/**
	 * Head was changed in the model object, so propagate the change to the
	 * database.
	 * 
	 * @param deptid
	 * @param head
	 *            (may be null)
	 */
	public void changeHead(int deptid, Faculty head) {
		try {
			String cmd = "update DEPARTMENT set Head = ? where DeptId = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			if (head != null) {
				// special handling because the head might be null
				pstmt.setInt(1, head.getSsn());
			} else {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			pstmt.setInt(2, deptid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error changing head", e);
		}
	}

	/**
	 * Retrieve a Collection of all Faculty in the given department. Backwards
	 * direction of DId foreign key from Faculty.
	 * 
	 * @param deptid
	 * @return the Collection
	 */
	public Collection<Faculty> getFaculty(int deptid) {
		try {
			Collection<Faculty> faculty = new ArrayList<Faculty>();
			String qry = "select SSN from FACULTY where DId = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, deptid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int ssn = rs.getInt("SSN");
				faculty.add(dbm.findFaculty(ssn));
			}
			rs.close();
			return faculty;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting department faculty", e);
		}
	}

	/**
	 * Retrieve a Collection of all Courses offered by the given department.
	 * Backwards direction of Dept foreign key from Course.
	 * 
	 * @param deptid
	 * @return the Collection
	 */
	public Collection<Course> getCourses(int deptid) {
		try {
			Collection<Course> courses = new ArrayList<Course>();
			String qry = "select Num from COURSE where Dept = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, deptid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("Num");
				courses.add(dbm.findCourse(deptid, num));
			}
			rs.close();
			return courses;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting department courses", e);
		}
	}

	/**
	 * Retrieve the Faculty object for the head of the given department. See the
	 * discussion at the find(deptid) method for details; this is only needed
	 * because of the cyclic foreign keys.
	 * 
	 * @param deptid
	 * @return the Faculty object, or null if not found (or NULL in database)
	 */
	public Faculty getHead(int deptid) {
		try {
			String qry = "select Head from DEPARTMENT where DeptId = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, deptid);
			ResultSet rs = pstmt.executeQuery();

			// return null if department doesn't exist
			if (!rs.next())
				return null;

			int head = rs.getInt("Head");
			boolean headless = rs.wasNull(); // in case the getInt encountered a
												// SQL null value
			rs.close();

			if (headless)
				return null;
			return dbm.findFaculty(head);
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting department courses", e);
		}
	}

	/**
	 * Clear all data from the Department table.
	 * 
	 * @throws SQLException
	 */
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from DEPARTMENT";
		stmt.executeUpdate(s);
	}
}
