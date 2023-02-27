package com.dharun.course.admin;

import com.dharun.course.dto.Course;
import com.dharun.course.dto.Student;
import com.dharun.course.dto.Teacher;

public interface AdminModelCallBack {

	Teacher addTrainer(String username, String emailId, String phoneNumber, String password, String courseId);

	Course getCourse(String courseId);

	Course addCourse(String courseName, String startDate, long duration, int cost, String startTime, String endTime,
			String trainerId);

	boolean removeCourse(String courseId);

	boolean changeTrainer(String trainerId, String courseId);


}
