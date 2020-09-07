package edu.depauw.csc480.model;

import edu.depauw.csc480.dao.BItemDAO;

public class BItem {
	private BItemDAO dao;
	private Patient patient;
	private Service service;
	
	public BItem(BItemDAO dao, Patient patient, Service service) {
		this.dao = dao;
		this.patient = patient;
		this.service = service;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public Service getService() {
		return service;
	}
}
