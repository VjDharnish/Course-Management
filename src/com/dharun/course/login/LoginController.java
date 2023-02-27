package com.dharun.course.login;
import java.util.List;

import com.dharun.course.dto.Student;
import com.dharun.course.dto.Teacher;

import utility.Validator;
public class LoginController implements LoginControllerCallBack,LoginControllerModelCallBack {

	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	public LoginController(LoginViewCallBack loginView) {
		// TODO Auto-generated constructor stub
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}
	@Override
	public void loginOptions(char option) {
		switch(option) {
		case '1':
			loginView.studentLogin();
			break;
		case '2':	
			loginView.studentSignup();
			break;
		case '3':
			loginView.trainerLogin();
			break;
		case '4':
			loginView.adminLogin();
			break;
		case'5':
			loginView.exit();
		default:
			loginView.invalidOption("Invalid Option");
			break;
		}
		
	}
	@Override
	public void checkStudent(String username, String password) {
		List<String> name = loginModel.checkCredentialOnline(username,password);
		if(name!=null) {
			loginView.verifiedStudent(name);
		}
		else {
			loginView.invalidOption("Invalid Credentials");
		}
		
	}
	@Override
	public void checkTrainer(String userId, String password) {
		Teacher trainer  = loginModel.checkTrainerCredential(userId,password);
		if(trainer == null) {
			loginView.invalidOption("Invalid Credentials");
		}
		loginView.verifiedTrainer(trainer.getTrainerId(),trainer.getTrainerId(),trainer.getUsername(),trainer.getPhoneNumber(),trainer.getCourse());
		
	}
	@Override
	public void addStudent(String username, String emailId, String phoneNumber, String password) {	
	 //TO-DO
		Student profile = loginModel.addStudent(username, emailId,phoneNumber, password);
		if(profile  == null) {
			loginView.invalidOption("Student Already Present");
		}
		loginView.signupSuccess(profile.getStudentId());
		
	}
	@Override
	public void checkAdmin(String username, String password) {
		if(loginModel.verifyAdmin(username,password)) {
			loginView.adminVerified();
		}
		else {
			loginView.invalidOption("Invalid Admin Credentials");
		}
		
		
	}
	@Override
	public void validateEmail(String username, String emailId) {
		if(Validator.validateEmail(emailId))
			loginView.enterPhonenumber(username,emailId);
		else
			loginView.invalidEmail(username);
	}
	@Override
	public void validatePhonenumber(String username, String email, String phoneNumber) {
		if(Validator.validatePhone(phoneNumber))
			loginView.enterPassword(username,email,phoneNumber);
		else
			loginView.invalidPhone(username,email);
	}
		
}


