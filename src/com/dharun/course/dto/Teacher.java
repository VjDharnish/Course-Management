package com.dharun.course.dto;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
	private String trainerId;

	private List<Course> courses = new ArrayList<>();
	public Teacher(String trainerId,String username, String email, String phoneNumber, Course course) {
		super(username, email, phoneNumber);
		this.trainerId=trainerId;
		this.courses.add(course);
		
	}
	public Teacher(String trainerId,String username, String email, String phoneNumber) {
		super(username, email, phoneNumber);
		this.trainerId=trainerId;
		
	}
	public List<Course> getCourse() {
		return courses;
	}
	public void setCourse(Course course) {
		this.courses.add(course);
	}
	public String getTrainerId() {
		return trainerId;
	}
	@Override
	public String toString() {
		return "Teacher [trainerId=" + trainerId + ", courses=" + courses + ", getUsername()=" + getUsername()
				+ ", getEmail()=" + getEmail() + ", getPhoneNumber()=" + getPhoneNumber() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
		
}
