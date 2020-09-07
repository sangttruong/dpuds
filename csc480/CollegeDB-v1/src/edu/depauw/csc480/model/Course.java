package edu.depauw.csc480.model;

import edu.depauw.csc480.dao.CourseDAO;

/**
 * Model object for a row in the Course table.
 * Accesses the underlying database through a CourseDAO.
 * Based on Sciore, Section 9.1.
 * 
 * @author bhoward
 */
public class Course {
	private CourseDAO dao;
	private Department dept;
	private int num;
	private String title;
	private Faculty faculty;

	public Course(CourseDAO dao, Department dept, int num, String title, Faculty faculty) {
		this.dao = dao;
		this.dept = dept;
		this.num = num; 
		this.title = title;
		this.faculty = faculty;
	}
	
	public String toString() {
		return dept + " " + num + ": " + title + ", " + faculty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		dao.changeTitle(dept, num, title);
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
		dao.changeFaculty(dept, num, faculty);
	}

	public Department getDept() {
		return dept;
	}

	public int getNum() {
		return num;
	}
}
