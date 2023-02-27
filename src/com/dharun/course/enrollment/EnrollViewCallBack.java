package com.dharun.course.enrollment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import com.dharun.course.dto.Course;
import com.dharun.course.dto.Teacher;




public interface EnrollViewCallBack {


	void viewCourses(HashMap<String, String> courseView);

	void applyCourse(String courseId, String courseName, long duration, LocalDate startDate, LocalDate endDate,
			LocalTime startTime, LocalTime endTime, int cost, int studentNo, String trainerNmae);

	void enrollOptions();

	void payment();

	

	void invalidAmount(String string, String string2, long l, LocalDate localDate, LocalDate localDate2, LocalTime localTime, LocalTime localTime2, int i, int j, String string3);

	void joinedSuccess(LocalDate joinDate);

	void invalidOption(String string);

	void backHome();

	void enrolledCourses(HashMap<String, String> enrolledCourseView);


	

}
