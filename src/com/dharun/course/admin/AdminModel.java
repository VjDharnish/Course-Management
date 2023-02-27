package com.dharun.course.admin;

import com.dharun.course.dto.Course;
import com.dharun.course.dto.Student;
import com.dharun.course.dto.Teacher;
import com.dharun.trainercentral.repository.TrainerCentralRepo;

public class AdminModel implements AdminModelCallBack {
	private static int tid = 2;
	private AdminControllerModelCallBack adminController;
	private static int cid = 2;

	public AdminModel(AdminControllerModelCallBack loginController) {
		// TODO Auto-generated constructor stub
		this.adminController = loginController;
	}

	@Override
	public Teacher addTrainer(String username, String emailId, String phoneNumber, String password, String courseId) {

		String trainerId = "TID00" + ++tid;
		Teacher trainer = TrainerCentralRepo.getInstance().addTrainer(trainerId, username, emailId, phoneNumber,
				password, courseId);
		return trainer;
	}

	@Override
	public Course getCourse(String courseId) {
		Course course = TrainerCentralRepo.getInstance().getCourse(courseId);
		return course;
	}

	@Override
	public Course addCourse(String courseName, String startDate, long duration, int cost, String startTime,
			String endTime, String trainerId) {
		Teacher trainer = TrainerCentralRepo.getInstance().getTrainer(trainerId);
		if (trainer == null)
			return null;
		String courseId = "CID00" + ++cid;
		Course course = TrainerCentralRepo.getInstance().addCourse(courseId, courseName, startDate, duration, cost,
				startTime, endTime, trainer);
		return course;
	}

	@Override
	public boolean removeCourse(String courseId) {

		return TrainerCentralRepo.getInstance().removeCourse(courseId);
	}

	@Override
	public boolean changeTrainer(String trainerId, String courseId) {
		if (TrainerCentralRepo.getInstance().changeTrainer(trainerId, courseId))
			return true;
		return false;
	}

}
