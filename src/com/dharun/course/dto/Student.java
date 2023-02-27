package com.dharun.course.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Student extends Person{
	private String studentId;
	HashSet<Course> courses  =new HashSet<>();
	public Student(String studentId,String username, String email, String phoneNumber) {
		super(username, email, phoneNumber);
		this.studentId=studentId;
	}
	public HashSet<Course> getCourses() {
		return courses;
	}
	public void setCourses(Course course) {
		courses.add(course);
	
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	
	 

}
