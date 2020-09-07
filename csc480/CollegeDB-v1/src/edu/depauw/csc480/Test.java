package edu.depauw.csc480;

import java.util.Collection;

import edu.depauw.csc480.dao.DatabaseManager;
import edu.depauw.csc480.model.Course;
import edu.depauw.csc480.model.Department;
import edu.depauw.csc480.model.Faculty;

/**
 * Simple client that inserts sample data then runs a query.
 * 
 * @author bhoward
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatabaseManager dbm = new DatabaseManager();
		
		dbm.clearTables();
		
		// department heads are set to null for now; see below
		Department chem = dbm.insertDepartment(5, "Chemistry", null);
		Department eng = dbm.insertDepartment(8, "English", null);
		Department mathcs = dbm.insertDepartment(10, "MathCS", null);

		Faculty john = dbm.insertFaculty(123456789, "John White", "Professor", mathcs);
		Faculty lee = dbm.insertFaculty(234567890, "Lee Williams", "Associate", mathcs);
		Faculty ellen = dbm.insertFaculty(345678901, "Ellen Mitchell", "Associate", chem);
		Faculty alice = dbm.insertFaculty(456789012, "Alice Trupe", "Professor", eng);
		Faculty owen = dbm.insertFaculty(567890123, "Owen Keefer", "Assistant", mathcs);
		dbm.insertFaculty(678901234, "Erich Brumbaugh", "Emeritus", chem);
		
		// Have to set department heads after creating faculty,
		// because faculty need to refer to departments (cycle in foreign keys)
		chem.setHead(ellen);
		eng.setHead(alice);
		mathcs.setHead(lee);
		
		dbm.insertCourse(mathcs, 131, "Calculus", john);
		dbm.insertCourse(chem, 310, "Physical Chemistry", john);
		dbm.insertCourse(mathcs, 100, "Computer Science I", lee);
		dbm.insertCourse(mathcs, 110, "Computer Science II", lee);
		dbm.insertCourse(mathcs, 381, "Databases", lee);
		dbm.insertCourse(chem, 320, "Organic Chemistry", ellen);
		dbm.insertCourse(chem, 100, "Chemistry I", ellen);
		dbm.insertCourse(eng, 110, "College Writing", alice);
		dbm.insertCourse(mathcs, 285, "Documentation", alice);
		dbm.insertCourse(mathcs, 420, "Syntax", owen);
		dbm.insertCourse(eng, 364, "Syntax", owen);
		
		dbm.commit();
		
		// Now retrieve a table of MathCS faculty and their courses;
		// each course also lists the head of the department offering the course
		Collection<Faculty> faculty = mathcs.getFaculty();
		for (Faculty fac : faculty) {
			System.out.println(fac);
			Collection<Course> courses = fac.getCourses();
			for (Course c : courses) {
				System.out.println("  " + c + " [Head: " + c.getDept().getHead() + "]");
			}
		}
		
		dbm.commit();
		
		dbm.close();
		
		System.out.println("Done");
	}

}
