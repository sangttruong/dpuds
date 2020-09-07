package edu.depauw.csc480.model;

import edu.depauw.csc480.dao.RoomDAO;

public class Room extends Service {
	private RoomDAO dao;
	private int id;
	private String type;
	private boolean isFull;
	private Service service;

	public Room(RoomDAO dao, int id, String type, boolean isFull, Service service) {
		super(service.getDAO(), service.getID(), service.getCharge());
		this.dao = dao;
		this.id = id;
		this.type = type;
		this.isFull = isFull;
		this.service = service;
	}

	@Override
	public String toString() {
		return id + ": " + type 
				+ '\n' + "This room is full: " + isFull
				+ '\n' + service;
	}
	
	public Service getService() {
		return service;
	}
	
	public void setFull(boolean isFull) {
		this.isFull = isFull;
		dao.setFull(id, isFull);
	}
}