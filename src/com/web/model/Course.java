package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	private int CourseId;
	private String CName;
	private float CFees;
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public float getCFees() {
		return CFees;
	}
	public void setCFees(float cFees) {
		CFees = cFees;
	}
	
	
}
