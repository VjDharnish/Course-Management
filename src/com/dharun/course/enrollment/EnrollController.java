package com.dharun.course.enrollment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.dharun.course.dto.*;

import utility.Validator;

public class EnrollController implements EnrollControllerCallBack, EnrollControllerModelCallBack {

	private EnrollViewCallBack enrollView;
	private EnrollModelCallBack enrollModel;
	private static HashSet<Course> courses = new HashSet<>();
	private Course newCourse;

	public EnrollController(EnrollViewCallBack enrollView) {
		// TODO Auto-generated constructor stub
		this.enrollView = enrollView;
		this.enrollModel = new EnrollModel(this);
	}

	@Override
	public void enrollOptions(char option,String userId) {
		switch (option) {
		case '1':
			courses = enrollModel.viewCourses();
			HashMap<String, String> courseView = new HashMap<>();
			for (Course course : courses) {

				courseView.put(course.getCourseId(), course.getCourseName());
			}
			enrollView.viewCourses(courseView);
			break;

		case '2':
			HashSet<Course> enrolledCourses =enrollModel.getEnrolledCourse(userId);
			HashMap<String, String> enrolledCourseView = new HashMap<>();
			for (Course course : enrolledCourses) {

				enrolledCourseView.put(course.getCourseId(), course.getCourseName());
			}
			enrollView.enrolledCourses(enrolledCourseView);
			
			break;
		case '3':
			break;
		case '4':
			enrollView.backHome();
			break;
		default:
			enrollView.invalidOption("Invalid Option");

		}

	}

	@Override
	public void applyCourse(String courseId) {

		for (Course course : courses) {

			if (course.getCourseId().equals(courseId)) {
				newCourse = course;

				enrollView.applyCourse(course.getCourseId(), course.getCourseName(), course.getDuration(),
						course.getStartDate(), course.getEndDate(), course.getStartTime(), course.getEndTime(),
						course.getCost(), course.getStudentNo(), course.getTrainer().getUsername());
			}
		}
		enrollView.invalidOption("Invalid Course ID");
		return;

	}

	@Override
	public void enrollConfirm(String course) {
		if (course.equals("-1")) {
			enrollView.enrollOptions();
		} else {
			enrollView.payment();
		}

	}

	@Override
	public void enrolling(String amount, String userId) {
		try {
			int amt = Integer.parseInt(amount);
			if (amt != newCourse.getCost()) {
				throw new Exception();
			}

			Course course = enrollModel.enrolling(userId, amt, newCourse);
			if(course == null) {
				enrollView.invalidOption("Course Already Enrolled");
				return;
			}
			
			enrollView.joinedSuccess(course.getStartDate());
		} catch (Exception e) {
			
			enrollView.invalidAmount(newCourse.getCourseId(), newCourse.getCourseName(), newCourse.getDuration(),
					newCourse.getStartDate(), newCourse.getEndDate(), newCourse.getStartTime(), newCourse.getEndTime(),
					newCourse.getCost(), newCourse.getStudentNo(), newCourse.getTrainer().getUsername());
		}

	}

}
