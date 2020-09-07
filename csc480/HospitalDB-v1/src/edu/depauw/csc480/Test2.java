package edu.depauw.csc480;

import java.util.Collection;

import edu.depauw.csc480.dao.DatabaseManager;
import edu.depauw.csc480.model.BItem;
import edu.depauw.csc480.model.Doctor;
import edu.depauw.csc480.model.DoctorLab;
import edu.depauw.csc480.model.Lab;
import edu.depauw.csc480.model.Patient;
import edu.depauw.csc480.model.Service;

public class Test2 {
	public static void main(String[] args) {
		DatabaseManager dbm = new DatabaseManager();		
		
		// 1. Given patient John with id 123, retrieve all services that associates with that patient.
		Patient john = dbm.findPatient(123);	
		System.out.println("1. Given patient John with id 123, retrieve all services that associates with that patient");
		Collection<BItem> bitemlist1 = john.getBItemList();
		for (BItem bitem: bitemlist1) {
			System.out.println(bitem.getService());
		}
		System.out.println('\n');
		
		// 2. Given sid 444, identify what service associating with that service.
		Service regularRoom = dbm.findService(444);
		System.out.println("2. Given service regular room, identify what is the charge of that service.");
		System.out.println(regularRoom);
		
		System.out.println('\n');
		
		// 3. Given doctor Shawn who has head scan service (sid = 222), identify patient(s) who visit this doctor.
		Service headscan = dbm.findService(222);
		Doctor shawn = dbm.findDoctor(headscan);
		System.out.println("3. Given doctor Shawn, identify patient(s) who visit this doctor (for the headscan)");
		Service ser = shawn.getService();
		Collection<BItem> bitemlist2 = ser.getBItem(ser.getID());
		for (BItem bitem: bitemlist2) {
			System.out.println(bitem.getPatient());
		}
		System.out.println('\n');
		
		// 4. Given biochemistry lab, retrieve all doctors in their lab, their expertise, and their service.
		Service regTest = dbm.findService(666);
		Lab biochem = dbm.findLab(regTest);
		System.out.println("4. Given biochemistry lab, retrieve all doctors in their lab, their expertise, and their service;");
		Collection<DoctorLab> doctorlist = biochem.getDoctorList();
		for (DoctorLab doc : doctorlist) {
			System.out.println(doc.getDoctor());
		}
		System.out.println('\n');
		
		dbm.commit();
		
		dbm.close();
		
		System.out.println("Done");
	}
}