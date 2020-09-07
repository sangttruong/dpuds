package edu.depauw.csc480.model;

import java.util.Collection;
import edu.depauw.csc480.dao.LabDAO;

public class Lab extends Service{
	private int id;
	private String function;
	private Service service;
	private LabDAO dao;
	private Collection<DoctorLab> doctorlist;
	
	
	public Lab(LabDAO dao, int id, String function, Service service) {
		super(service.getDAO(), service.getID(), service.getCharge());
		this.dao = dao;
		this.id = id;
		this.function = function;
		this.service = service;
	}
	
	@Override
	public String toString() {
		return id + ": " + function + '\n' + service;
	}
	
	public Service getService() {
		return service;
	}
	
	public Collection<DoctorLab> getDoctorList() {
		if (doctorlist == null) doctorlist = dao.getDoctorList(service);
		return doctorlist;
	}
}
