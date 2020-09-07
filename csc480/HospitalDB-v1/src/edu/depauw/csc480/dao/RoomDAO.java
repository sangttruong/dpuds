package edu.depauw.csc480.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.depauw.csc480.model.Room;
import edu.depauw.csc480.model.Service;

public class RoomDAO {
	private Connection conn;
	private DatabaseManager dbm;

	public RoomDAO(Connection conn, DatabaseManager dbm) {
		this.conn = conn;
		this.dbm = dbm;
	}

	static void create(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "create table ROOM ("
				 + " rid integer not null,"
				 + " type varchar(15) not null,"
				 + " isfull boolean not null,"
				 + " sid integer not null,"
				 + " primary key (sid),"
				 + " foreign key (sid) references SERVICE"
				 + " on delete no action)";
		stmt.executeUpdate(s);
	}

	public Room find(Service service) {
		try {
			String qry = "select * from ROOM where sid = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, service.getID());
			ResultSet rs = pstmt.executeQuery();

			// return null if room doesn't exist
			if (!rs.next())
				return null;

			int id = rs.getInt("rid");
			String type = rs.getString("type");
			boolean isfull = rs.getBoolean("isfull");
			
			rs.close();

			Room room = new Room(this, id, type, isfull, service);

			return room;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding room", e);
		}
	}

	public Room insert(int id, String type, boolean isfull, Service service) {
		try {
			// make sure that the service is currently unused
			if (find(service) != null)
				return null;

			String cmd = "insert into ROOM(rid, type, isfull, sid)"
					+ "values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setInt(1, id);
			pstmt.setString(2, type);
			pstmt.setBoolean(3, isfull);
			pstmt.setInt(4, service.getID());
			pstmt.executeUpdate();

			Room room = new Room(this, id, type, isfull, service);

			return room;
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting new room", e);
		}
	}

	public void setFull(int id, boolean isfull) {
		try {
			String cmd = "update ROOM set isfull = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setBoolean(1, isfull);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error setting the fact that room is full", e);
		}		
	}
	
	void clear() throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "delete from ROOM";
		stmt.executeUpdate(s);
	}
}