package com.dharun.course.enrollment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.dharun.course.dto.Course;
import com.dharun.course.login.LoginView;

import utility.Validator;
public class EnrollView implements  EnrollViewCallBack {
	private EnrollControllerCallBack enrollController;
	private Scanner scanner = new Scanner(System.in);
	private String username;
	private LoginView loginView;
	public EnrollView(LoginView loginView, String username) {
		enrollController = new EnrollController(this);
		this.loginView = loginView;
		this.username = username;
	}
	public void enrollOptions(){
		System.out.println("\nStudent Options");
		System.out.println("Press 1 to View Courses");
		System.out.println("Press 2 to View Enrolled Courses");
		System.out.println("Press 4 to Back ");
		char option = scanner.next().charAt(0);
		enrollController.enrollOptions(option,username);
	}
	@Override
	public void viewCourses(HashMap<String,String> courses) {
		System.out.println("---->Course Details<----");
		System.out.println("Course ID\tCourse Name");
		Set<String> keys =courses.keySet();
		for(String key:keys) {
			System.out.println(key+"\t\t"+courses.get(key));
		}
		System.out.println("\n Click Course ID to Enroll");
		String courseId = scanner.next();
		enrollController.applyCourse(courseId);
		
	}
	@Override
	public void applyCourse(String courseId, String courseName, long duration, LocalDate startDate, LocalDate endDate,
			LocalTime startTime, LocalTime endTime, int cost, int studentNo,String trainerName) {
		System.out.println("---->Course Overview<----");
		System.out.println("Course Id : "+courseId+"\t\tStart Date : "+startDate);
		System.out.println("Course Name : "+courseName+"\t\tEnd Date : "+endDate);
		System.out.println("Trainer Name : "+trainerName+"\t\tDuration : "+duration);
		System.out.println("No of students Enrolled : "+ studentNo +"\t\tTiming : "+startTime+" - "+endTime);
		System.out.println("Cost : "+cost+"\t\t");
		System.out.println("Click Course ID  to Continue \t\t Press -1  to Cancel" );
		String course = scanner.next();
		enrollController.enrollConfirm(course);
	}
	@Override
	public void payment() {
		System.out.println("Enter Amount to Continue");
		String amount = scanner.next();
		enrollController.enrolling(amount,username);
		
	}

	@Override
	public void invalidAmount(String courseId, String courseName, long duration, LocalDate startDate, LocalDate endDate,
			LocalTime startTime, LocalTime endTime, int cost, int studentNo,String trainerName) {
		System.out.println("Invalid amount");
		applyCourse(courseId,courseName,duration,startDate,endDate,startTime,endTime,cost,studentNo,trainerName);
		
	}
	@Override
	public void joinedSuccess(LocalDate joinDate) {
		System.out.print("Redirecting Payment");
		for(int i =0;i<5;i++) {
		try {
			Thread.sleep(1000);
			System.out.print(".");
		}
		catch(InterruptedException e) {
			System.out.println("Network Error!");
			enrollOptions();
		}
		}
		System.out.println("\nYou Enrolled Sussessfully");
		System.out.println("PLz Come and Join on "+joinDate);
		enrollOptions();
		
	}
	@Override
	public void invalidOption(String string) {
		System.out.println(string);
		enrollOptions();
		
	}
	@Override
	public void backHome() {
		loginView.init();
		
	}
	@Override
	public void enrolledCourses(HashMap<String, String> enrolledCourseView) {
		System.out.println("---->Enrolled Course Details<----");
		System.out.println("Course ID\tCourse Name");
		Set<String> keys =enrolledCourseView.keySet();
		for(String key:keys) {
			System.out.println(key+"\t\t"+enrolledCourseView.get(key));
		}
		System.out.println();
		enrollOptions();
		
	}

	

}
