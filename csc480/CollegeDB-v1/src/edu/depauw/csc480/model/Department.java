package edu.depauw.csc480.model;

import java.util.Collection;

import edu.depauw.csc480.dao.DepartmentDAO;

/**
 * Model object for a row in the Department table.
 * Accesses the underlying database through a DepartmentDAO.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class Department {
	private DepartmentDAO dao;
	private int deptid;
	private String dname;
	private Faculty head;
	private Collection<Faculty> faculty;
	private Collection<Course> courses;

	public Department(DepartmentDAO dao, int deptid, String dname) {
		this.dao = dao;
		this.deptid = deptid;
		this.dname = dname;
		this.head = null;
	}
	
	public Department(DepartmentDAO dao, int deptid, String dname, Faculty head) {
		// Non-lazy version, in case we already know the head
		this(dao, deptid, dname);
		this.head = head;
	}

	public String toString() {
		return dname;
	}

	public int getDeptId() {
		return deptid;
	}

	public Faculty getHead() {
		// Compute department head lazily, to break the cycle
		// between Department and Faculty
		if (head == null) head = dao.getHead(deptid);
		return head;
	}

	public void setHead(Faculty head) {
		this.head = head;
		dao.changeHead(deptid, head);
	}

	public String getDname() {
		return dname;
	}

	public Collection<Faculty> getFaculty() {
		if (faculty == null) faculty = dao.getFaculty(deptid);
		return faculty;
	}

	public Collection<Course> getCourses() {
		if (courses == null) courses = dao.getCourses(deptid);
		return courses;
	}
}
