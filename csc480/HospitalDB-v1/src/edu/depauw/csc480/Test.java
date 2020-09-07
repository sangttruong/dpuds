package edu.depauw.csc480;

import java.util.Collection;

import edu.depauw.csc480.dao.DatabaseManager;
import edu.depauw.csc480.model.BItem;
import edu.depauw.csc480.model.Doctor;
import edu.depauw.csc480.model.DoctorLab;
import edu.depauw.csc480.model.Lab;
import edu.depauw.csc480.model.Patient;
import edu.depauw.csc480.model.Service;

public class Test {
	
	public static void main(String[] args) {
		DatabaseManager dbm = new DatabaseManager();
		
		dbm.clearTables();
		
		Patient john = dbm.insertPatient(123, "John White", 45, true, "123 South Locust Street", "123123123", true, "headache");
		Patient lee = dbm.insertPatient(456, "Lee Williams", 55, true, "456 South Locust Street", "456456456", true, "acne");
		Patient ellen = dbm.insertPatient(789, "Ellen Mitchell", 65, false, "789 South Locust Street", "789789789", true, "flu");
		Patient owen = dbm.insertPatient(101, "Alice Trupe", 75, false, "101 South Locust Street", "101101101", true, "headache");

		Service faceScan = dbm.insertService(111, 100.5);
		Service headScan = dbm.insertService(222, 55.3);
		Service bellyScan = dbm.insertService(333, 47.99);
		
		Service regularRoom = dbm.insertService(444, 100.00);
		Service premiumRoom = dbm.insertService(555, 200.00);
		
		Service regTest = dbm.insertService(666, 140);
		Service fastTest = dbm.insertService(777,  300);
		
		Doctor shane = dbm.insertDoctor(100, "Shane McClay", 31, true, "001 East Seminary", "001001001", "Cardiovascular disease", faceScan);
		Doctor shawn = dbm.insertDoctor(200, "Shawn McClay", 32, true, "002 East Seminary", "002002002", "Sesional disease", headScan);
		Doctor sean = dbm.insertDoctor(300, "Sean McClay", 33, true, "003 East Seminary", "003003003", "Head-related disease", bellyScan);
		
		dbm.insertRoom(001, "Regular", true, regularRoom);
		dbm.insertRoom(002, "Premium", false, premiumRoom);
		dbm.insertRoom(003, "Regular", true, regularRoom);
	
		Lab biochem = dbm.insertLab(001, "Biochemistry", regTest);
		Lab immu = dbm.insertLab(002,  "Immunology", fastTest);
		
		dbm.insertBItem(john, headScan);
		dbm.insertBItem(lee, faceScan);
		dbm.insertBItem(ellen, headScan);
		dbm.insertBItem(owen, headScan);
		
		dbm.insertDoctorLab(shane, biochem);
		dbm.insertDoctorLab(shawn, biochem);
		dbm.insertDoctorLab(sean, immu);
		
		dbm.commit();
		
		// 1. Given patient John with id 123, retrieve all services that associates with that patient.
		System.out.println("1. Given patient John with id 123, retrieve all services that associates with that patient");
		Collection<BItem> bitemlist1 = john.getBItemList();
		for (BItem bitem: bitemlist1) {
			System.out.println(bitem.getService());
		}
		System.out.println('\n');
		
		// 2. Given sid 444, identify what service associating with that service.
		System.out.println("2. Given service regular room, identify what is the charge of that service.");
		System.out.println(regularRoom);
		
		System.out.println('\n');
		
		// 3. Given doctor Shawn with id 200, identify patient(s) who visit this doctor.
		System.out.println("3. Given doctor Shawn, identify patient(s) who visit this doctor (for the headscan)");
		Service ser = shawn.getService();
		Collection<BItem> bitemlist2 = ser.getBItem(ser.getID());
		for (BItem bitem: bitemlist2) {
			System.out.println(bitem.getPatient());
		}
		System.out.println('\n');
		
		// 4. Given biochemistry lab, retrieve all doctors in their lab, their expertise, and their service.
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
