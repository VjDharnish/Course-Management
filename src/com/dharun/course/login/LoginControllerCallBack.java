package com.dharun.course.login;

import com.dharun.course.dto.Student;

public interface LoginControllerCallBack {

	void loginOptions(char option);

	void checkStudent(String username, String password);

	void checkTrainer(String username, String password);

	void addStudent(String username, String emailId, String phoneNumber, String password);

	void checkAdmin(String username, String password);

	void validateEmail(String username, String emailId);

	void validatePhonenumber(String username, String email, String phoneNumber);

}
