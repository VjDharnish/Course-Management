package com.dharun.course.login;

import java.util.List;

import com.dharun.course.dto.Student;
import com.dharun.course.dto.Teacher;
import com.dharun.trainercentral.repository.TrainerCentralRepo;

public class LoginModel implements LoginModelCallBack {

	private LoginControllerModelCallBack loginController;
	private static int stdId =2;
	public LoginModel(LoginControllerModelCallBack loginController) {
		// TODO Auto-generated constructor stub
		this.loginController = loginController;
	}

	@Override
	public List<String> checkCredentialOnline(String username, String password) {
		return TrainerCentralRepo.getInstance().checkCredential(username, password);
			
	}

	@Override
	public boolean verifyAdmin(String username, String password) {
		if (TrainerCentralRepo.getInstance().verifyAdmin(username, password))
			return true;
		return false;
	}

	@Override
	public Student addStudent(String username, String emailId, String phoneNumber, String password) {
		String studentId= "STD00" + ++stdId;
		Student student= TrainerCentralRepo.getInstance().addStudent(studentId,username, emailId,phoneNumber, password);
		return student;
	}

	@Override
	public Teacher checkTrainerCredential(String userId, String password) {
		Teacher trainer = TrainerCentralRepo.getInstance().checkCredential(userId, password,"trainer");
		return trainer;
	}

}
