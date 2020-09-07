package edu.depauw.csc480.model;

import java.util.Collection;

import edu.depauw.csc480.dao.DoctorDAO;

public class Doctor extends Service{
	private DoctorDAO dao;
	private int id;
	private String name;
	private int age;
	private boolean male;
	private String address;
	private String phone;
	private String expertise;
	private Service service;
	private Collection<DoctorLab> lablist;

	public Doctor(DoctorDAO dao, int id, String name, int age, boolean male, String address, String phone, String expertise, Service service) {
		super(service.getDAO(), service.getID(), service.getCharge());
		this.dao = dao;
		this.id = id;
		this.name = name;
		this.age = age;
		this.male = male;
		this.address = address;
		this.phone = phone;
		this.expertise = expertise;
		this.service = service;
	}
	
	@Override
	public String 	toString() {
		return name + " (ID = " + id + ", " + age + " years old, " + address + ", " + phone + "): " + expertise;
	}
	
	public int getID() {
		return id;
	}
	
	public boolean isMale() {
		return male;
	}
	
	public Service 	getService() {
		return service;
	}
	
	public Collection<DoctorLab> getLabList() {
		if (lablist == null) lablist = dao.getLabList(service);
		return lablist;
	}
	
	public void setExpertise(String expertise) {
		this.expertise = expertise;
		dao.setExpertise(service, expertise);
	}
}