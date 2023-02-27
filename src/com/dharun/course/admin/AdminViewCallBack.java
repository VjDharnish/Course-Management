package com.dharun.course.admin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;




public interface AdminViewCallBack {

	void addCourse();

	void removeCourse();

	void addTrainer();

	void backHome();

	void invalidOption(String string);

	void enterPassword(String username, String email, String phoneNumber);

	void invalidPhone(String username, String email);

	void invalidEmail(String username);

	void enterPhonenumber(String username, String emailId);

	void changeTrainer();


	void CourseDetails();

	void showCourse(String courseId, String courseName, int cost, long courseIncome, long l,
			LocalDate endDate, LocalTime localTime, LocalDate localDate, LocalTime endTime,
			int studentNo, String trainerId, String trainerName);

	void courseToRemove(String courseId, String courseName, int cost, long courseIncome, long duration,
			LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, int studentNo,
			String trainerId, String username);

	void adminOptions();

	void removeSuccess();

	void trainerDetails(String trainerId, String username, String email, String phoneNumber,
			HashMap<String, String> courses);

	void changeTrainerSuccess();

}
