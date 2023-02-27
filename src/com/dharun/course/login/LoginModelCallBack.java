package com.dharun.course.login;

import java.util.List;

import com.dharun.course.dto.Student;
import com.dharun.course.dto.Teacher;

public interface LoginModelCallBack {

	List<String> checkCredentialOnline(String username, String password);

	boolean verifyAdmin(String username, String password);

	Student addStudent(String username, String emailId, String phoneNumber, String password);

	Teacher checkTrainerCredential(String userId, String password);

}
