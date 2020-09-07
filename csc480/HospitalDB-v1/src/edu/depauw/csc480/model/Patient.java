package edu.depauw.csc480.model;

import java.util.Collection;

import edu.depauw.csc480.dao.PatientDAO;

public class Patient {
	private PatientDAO dao;
	private int id;
	private String name;
	private int age;
	private boolean male;
	private String address;
	private String phone;
	private boolean haveinsurance;
	private String disease;
	private Collection<BItem> bitemlist;

	public Patient(PatientDAO dao, int id, String name, int age, boolean male,
			String address, String phone, boolean haveinsurance, String disease) {
		this.dao = dao;
		this.id = id;
		this.name = name;
		this.age = age;
		this.male = male;
		this.phone = phone;
		this.haveinsurance = haveinsurance;
		this.disease = disease;
	}
	
	@Override
	public String toString() {
		return name + " (ID = " + id + ", " + age + " years old, " + address + ", " + phone + "): " + disease;
	}	
	
	public int getID() {return id; }

	public boolean isMale() {
		return male;
	}
	
	public boolean haveInsurance() {
		return haveinsurance;
	}
	
	public Collection<BItem> getBItemList(){
		if (bitemlist == null) bitemlist = dao.getBItemList(id);
		return bitemlist;
	}
}