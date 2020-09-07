package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.depauw.csc480.model.Course;
import edu.depauw.csc480.model.Department;
import edu.depauw.csc480.model.Faculty;

/**
 * Data Access Object for the Course table.
 * Encapsulates all of the relevant SQL commands.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class CourseDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public CourseDAO(Connection conn, DatabaseManager dbm) {
		this.conn = conn;
		this.dbm = dbm;
	}

	/**
	 * Create the Course table via SQL
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table COURSE("
				+ "Dept int, "
				+ "Num int, "
				+ "Title varchar(30) not null, "
				+ "FacSSN int, "
				+ "primary key(Dept, Num))";
		stmt.executeUpdate(s);
	}

	/**
	 * Modify the Course table to add foreign key constraints (needs to happen
	 * after the other tables have been created)
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	static void addConstraints(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "alter table COURSE add constraint fk_coursefac "
				+ "foreign key(FacSSN) references FACULTY on delete cascade";
		stmt.executeUpdate(s);
		s = "alter table COURSE add constraint fk_coursedept "
				+ "foreign key(Dept) references DEPARTMENT on delete cascade";
		stmt.executeUpdate(s);
	}

	/**
	 * Retrieve a Course object given its key.
	 * 
	 * @param deptid
	 * @param num
	 * @return the Course object, or null if not found
	 */
	public Course find(int deptid, int num) {
		try {
			String qry = "select Title, FacSSN from COURSE where Dept = ? and Num = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, deptid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();

			// return null if course doesn't exist
			if (!rs.next())
				return null;

			String title = rs.getString("Title");
			int facssn = rs.getInt("FacSSN");
			rs.close();

			Department dept = dbm.findDepartment(deptid);
			Faculty faculty = dbm.findFaculty(facssn);
			Course course = new Course(this, dept, num, title, faculty);

			return course;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding course", e);
		}
	}

	/**
	 * Add a new Course with the given attributes.
	 * 
	 * @param dept
	 * @param num
	 * @param title
	 * @param faculty
	 * @return the new Course object, or null if key already exists
	 */
	public Course insert(Department dept, int num, String title, Faculty faculty) {
		try {
			// make sure that the dept, num pair is currently unused
			if (find(dept.getDeptId(), num) != null)
				return null;

			String cmd = "insert into COURSE(Dept, Num, Title, FacSSN) "
					+ "values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, dept.getDeptId());
			pstmt.setInt(2, num);
			pstmt.setString(3, title);
			pstmt.setInt(4, faculty.getSsn());
			pstmt.executeUpdate();

			Course course = new Course(this, dept, num, title, faculty);

			return course;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new course", e);
		}
	}

	/**
	 * Title was changed in the model object, so propagate the change to the
	 * database.
	 * 
	 * @param dept
	 * @param num
	 * @param title
	 */
	public void changeTitle(Department dept, int num, String title) {
		try {
			String cmd = "update COURSE set Title = ? where Dept = ? and Num = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, title);
			pstmt.setInt(2, dept.getDeptId());
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error changing title", e);
		}
	}

	/**
	 * Faculty member was changed in the model object, so propagate the change
	 * to the database.
	 * 
	 * @param dept
	 * @param num
	 * @param faculty
	 */
	public void changeFaculty(Department dept, int num, Faculty faculty) {
		try {
			String cmd = "update COURSE set FacSSN = ? where Dept = ? and Num = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, faculty.getSsn());
			pstmt.setInt(2, dept.getDeptId());
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error changing faculty", e);
		}
	}

	/**
	 * Clear all data from the Course table.
	 * 
	 * @throws SQLException
	 */
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from COURSE";
		stmt.executeUpdate(s);
	}
}
