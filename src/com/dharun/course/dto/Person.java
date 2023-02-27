package com.dharun.course.dto;

public class Person {
	protected String username;
	protected String email;
	protected String phoneNumber;
	Person(String username,String email,String phoneNumber){
		this.username=username;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Person [username=" + username + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
