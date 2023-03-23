package com.web.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	private int studId;
	private String studName;
	private long sContactNo;
	private String sAddress;
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Course> Courses=new HashSet<Course>();
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public long getsContactNo() {
		return sContactNo;
	}
	public void setsContactNo(long sContactNo) {
		this.sContactNo = sContactNo;
	}
	public Set<Course> getCourses() {
		return Courses;
	}
	public void setCourses(Set<Course> courses) {
		Courses = courses;
	}
	
	
}
