package com.dharun.course.login;

import java.util.List;

import com.dharun.course.dto.Course;

public interface LoginViewCallBack {

	void studentLogin();

	void studentSignup();

	void trainerLogin();

	void adminLogin();

	void exit();

	void invalidOption(String errMsg);

	

	void verifiedStudent(List<String> name);

	void adminVerified();

	void enterPhonenumber(String username, String emailId);

	void enterPassword(String username, String email, String phoneNumber);

	void invalidEmail(String username);

	void invalidPhone(String username, String email);

	void signupSuccess(String string);

	void verifiedTrainer(String trainerId, String trainerId2, String email, String phoneNumber, List<Course> course);

}
