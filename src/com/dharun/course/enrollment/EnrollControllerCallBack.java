package com.dharun.course.enrollment;



public interface EnrollControllerCallBack {

	void enrollOptions(char option,String userId);

	void applyCourse(String courseId);

	void enrollConfirm(String course);

	void enrolling(String amount, String username);


}
