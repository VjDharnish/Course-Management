package com.dharun.course.admin;

import com.dharun.course.dto.Student;

public interface AdminControllerCallBack {

	void options(char option);

	void validatePhonenumber(String username, String email, String phoneNumber);

	void addTrainer(String username, String emailId, String phoneNumber, String password, String courseId);

	void validateEmail(String username, String emailId);

	void getCourse(String courseId);

	void addCourse(String courseName, String startDate, long duration, int cost, String startTime, String endTime,
			String trainerId);

	void courseToRemove(String courseId);

	void removeCourse(String confirm, String courseId);

	void changeTrainer(String trainerId, String courseId);


}
