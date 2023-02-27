package com.dharun.course.admin;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.dharun.course.dto.*;

import utility.Validator;
public class AdminController implements AdminControllerCallBack,AdminControllerModelCallBack {

	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;
	public AdminController(AdminViewCallBack adminView) {
		// TODO Auto-generated constructor stub
		this.adminView = adminView;
		this.adminModel = new AdminModel(this);
	}
	@Override
	public void options(char option) {
		switch(option) {
		case '1':
			adminView.addCourse();
			break;
		case '2':
			adminView.removeCourse();
			break;
		case '3':
			adminView.addTrainer();
			break;
		case '4':
			adminView.changeTrainer();
			break;
		case '5':
			adminView.CourseDetails();
			break;
		case '6':
			adminView.backHome();
			break;
		default:
			adminView.invalidOption("Invalid Option");
			break;
			
		}
		
	}
	@Override
	public void validateEmail(String username, String emailId) {
		if(Validator.validateEmail(emailId))
			adminView.enterPhonenumber(username,emailId);
		else
			adminView.invalidEmail(username);
	}
	@Override
	public void validatePhonenumber(String username, String email, String phoneNumber) {
		if(Validator.validatePhone(phoneNumber))
			adminView.enterPassword(username,email,phoneNumber);
		else
			adminView.invalidPhone(username,email);
	}
	@Override
	public void addTrainer(String username, String emailId, String phoneNumber, String password,String courseId) {
		Teacher trainer =  adminModel.addTrainer(username, emailId,phoneNumber, password,courseId);
		if(trainer == null) {
			adminView.invalidOption("Invalid Course ID or Trainer Already Present");
		}
		else {
			HashMap<String,String> courses = new HashMap<>();
			for(Course course:trainer.getCourse()) {
				courses.put(course.getCourseId(),course.getCourseName());
			}
			adminView.trainerDetails(trainer.getTrainerId(),trainer.getUsername(),trainer.getEmail(),trainer.getPhoneNumber(),courses);
		}
	}
	@Override
	public void getCourse(String courseId) {
		Course course  = adminModel.getCourse(courseId);
		if(course == null) {
			adminView.invalidOption("Course Not Available");
			return;
	}
		adminView.showCourse(course.getCourseId(),course.getCourseName(),course.getCost(),course.getCourseIncome(),course.getDuration(),course.getStartDate(),course.getStartTime(),course.getEndDate(),course.getEndTime(),course.getStudentNo(),course.getTrainer().getTrainerId(),course.getTrainer().getUsername());
	}
	@Override
	public void addCourse(String courseName, String startDate, long duration, int cost, String startTime,
			String endTime, String trainerId) {
		if(! Validator.validateDate(startDate)) {
			adminView.invalidOption("Invalid Date");
			return;
		}
		
		Course course  = adminModel.addCourse(courseName,startDate,Math.abs(duration),cost,startTime,endTime,trainerId);
		if(course == null)
			adminView.invalidOption("Invalid Course Details");
		else {
			adminView.showCourse(course.getCourseId(),course.getCourseName(),course.getCost(),course.getCourseIncome(),course.getDuration(),course.getStartDate(),course.getStartTime(),course.getEndDate(),course.getEndTime(),course.getStudentNo(),course.getTrainer().getTrainerId(),course.getTrainer().getUsername());
		}
	}
	@Override
	public void courseToRemove(String courseId) {
		Course course  = adminModel.getCourse(courseId);
		if(course == null)
			adminView.invalidOption("Course Not Available");
		adminView.courseToRemove(course.getCourseId(),course.getCourseName(),course.getCost(),course.getCourseIncome(),course.getDuration(),course.getStartDate(),course.getStartTime(),course.getEndDate(),course.getEndTime(),course.getStudentNo(),course.getTrainer().getTrainerId(),course.getTrainer().getUsername());
	}
	@Override
	public void removeCourse(String confirm, String courseId) {
		if(! confirm.equalsIgnoreCase("ok"))
			adminView.adminOptions();
			boolean remove = adminModel.removeCourse(courseId);
			if(remove)
				adminView.removeSuccess();
			else
				adminView.invalidOption("Course remove Failed");
		
	}
	@Override
	public void changeTrainer(String trainerId, String courseId) {
		if(adminModel.changeTrainer(trainerId,courseId)) {
			adminView.changeTrainerSuccess();
		}
		else {
			adminView.invalidOption("Invalid Trainer Id/course ID");
		}
		
	}

		
}


