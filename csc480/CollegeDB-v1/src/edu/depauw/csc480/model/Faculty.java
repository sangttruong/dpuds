package edu.depauw.csc480.model;

import java.util.Collection;

import edu.depauw.csc480.dao.FacultyDAO;

/**
 * Model object for a row in the Faculty table.
 * Accesses the underlying database through a FacultyDAO.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class Faculty {
	private FacultyDAO dao;
	private int ssn;
	private String fname;
	private String rank;
	private Department dept;
	private Collection<Course> courses;
	private Collection<Department> departments;

	public Faculty(FacultyDAO dao, int ssn, String fname, String rank, Department dept) {
		this.dao = dao;
		this.ssn = ssn;
		this.fname = fname;
		this.rank = rank;
		this.dept = dept;
	}
	
	public String toString() {
		return fname + ", " + rank + ", " + dept;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
		dao.changeRank(ssn, rank);
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
		dao.changeDept(ssn, dept);
	}

	public int getSsn() {
		return ssn;
	}

	public String getFname() {
		return fname;
	}

	public Collection<Course> getCourses() {
		if (courses == null) courses = dao.getCourses(ssn);
		return courses;
	}

	public Collection<Department> getDepartments() {
		if (departments == null) departments = dao.getDepartments(ssn);
		return departments;
	}
}
