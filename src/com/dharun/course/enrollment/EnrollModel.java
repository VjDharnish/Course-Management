package com.dharun.course.enrollment;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import com.dharun.course.dto.*;
import com.dharun.trainercentral.repository.TrainerCentralRepo;

public class EnrollModel implements EnrollModelCallBack {

	private EnrollControllerModelCallBack  enrollController;

	public EnrollModel(EnrollControllerModelCallBack loginController) {
		// TODO Auto-generated constructor stub
		this. enrollController = loginController;
	}

	@Override
	public HashSet<Course> viewCourses() {
		return TrainerCentralRepo.getInstance().getCourses();
		
	}

	@Override
	public Course enrolling(String userId, int amount,Course course) {
		
		Course joinCourse = TrainerCentralRepo.getInstance().joinCourse(userId,amount,course);
		return joinCourse;
	}

	@Override
	public HashSet<Course> getEnrolledCourse(String userId) {
	
		return TrainerCentralRepo.getInstance().getEnrolledCourses(userId);
	}



}
