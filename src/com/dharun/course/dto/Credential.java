package com.dharun.course.dto;

public class Credential {
	private String userId;
	private String username;
	private String password;
	private String category;
	public Credential(String userId,String username,String password,String category){
		this.userId = userId;
		this.username =username;
		this.password = password;
		this.category = category;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
