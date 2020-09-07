package edu.depauw.csc480.model;

import java.util.Collection;

import edu.depauw.csc480.dao.ServiceDAO;

public class Service {
	private ServiceDAO dao;
	private int id;
	private double charge;
	private Collection<BItem> bitemlist;
	
	public Service(ServiceDAO dao, int id, double charge) {
		this.dao = dao;
		this.id = id;
		this.charge = charge;
	}

	@Override
	public String toString() { return id + ": $" + charge; }

	public ServiceDAO getDAO() { return dao; }
	
	public int getID() { return id; }
	
	public double getCharge() { return charge; }
	
	public Collection<BItem> getBItem(int id){
		if (bitemlist == null) bitemlist = dao.getBItemList(id);
		return bitemlist;
	}
	
	public void setCharge(double charge) {
		this.charge = charge;
		dao.setCharge(id, charge);
	}
}