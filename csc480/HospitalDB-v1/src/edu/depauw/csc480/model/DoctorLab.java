package edu.depauw.csc480.model;

import edu.depauw.csc480.dao.DoctorLabDAO;

public class DoctorLab {
	
	private Doctor doctor;
	private Lab lab;
	private DoctorLabDAO dao;
	
	public DoctorLab (DoctorLabDAO dao, Doctor doctor, Lab lab) {
		this.dao = dao;
		this.doctor = doctor;
		this.lab = lab;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public Lab getLab() {
		return lab;
	}

}
