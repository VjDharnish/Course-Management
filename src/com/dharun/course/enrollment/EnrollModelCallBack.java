package com.dharun.course.enrollment;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import com.dharun.course.dto.Course;
import com.dharun.course.dto.Student;

public interface EnrollModelCallBack {

	HashSet<Course> viewCourses();

	Course enrolling(String userId, int amount, Course course);

	HashSet<Course> getEnrolledCourse(String userId);


}
