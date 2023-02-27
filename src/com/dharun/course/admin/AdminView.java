package com.dharun.course.admin;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.dharun.course.login.LoginView;

public class AdminView implements  AdminViewCallBack {
	private AdminControllerCallBack adminController;
	private Scanner scanner = new Scanner(System.in);
   private LoginView loginView;
	public AdminView(LoginView loginView) {
		adminController = new AdminController(this);
		this.loginView = loginView;
	}
	public void adminOptions(){
		System.out.println("\nPress 1 to Add Course");   //done
		System.out.println("Press 2 to Remove Course");  //done
		System.out.println("Press 3 to Add Trainer");    //done
		System.out.println("Press 4 to change Course Trainer"); //done
		System.out.println("Press 5 to View Courses");    //done
		System.out.println("Press 6 to back to Home");    //done
		System.out.println("\nEnter your Choice");
		char option = scanner.next().charAt(0);
		adminController.options(option);
		
	}
	@Override
	public void addCourse() {
		System.out.println("\nEnter Course Details");
		System.out.println("Enter Course Name:");
		String courseName  = scanner.next();
		System.out.println("Enter Start Date:");
		String startDate = scanner.next();
		System.out.println("Enter Course Duration:");
		long duration = scanner.nextLong();
		System.out.println("Enter Course Fee:");
		int cost = scanner.nextInt();
		System.out.println("Enter Start Time:");
		String startTime = scanner.next();
		System.out.println("Enter End Time:");
		String endTime  = scanner.next();
		System.out.println("Enter Trainer ID:");
		String trainerId = scanner.next();
		adminController.addCourse(courseName,startDate,duration,cost,startTime,endTime,trainerId);
	}
	/*-------------------REMOVE COURSE----------------*/
	@Override
	public void removeCourse() {
		System.out.println("\nEnter Course ID:");
		String courseId = scanner.next();
		adminController.courseToRemove(courseId);
		
	}
	
	@Override
	public void backHome() {
		loginView.init();
		
	}
	
	/*------------------- ADD TRAINER DETAILS -----------------*/
	@Override
	public void addTrainer() {
		System.out.println("\nEnter Trainer Details");
		System.out.println("Enter Trainer Name:");
		String name = scanner.next();
		enterMail(name);
		
	}
	private void enterMail(String username) {
		System.out.println("Enter Email Id");
		String emailId = scanner.next();
		adminController.validateEmail(username,emailId);
		
		
	}
	public void enterPhonenumber(String username,String email) {
		System.out.println("Enter Phone Number:");
		String phoneNumber = scanner.next();
		adminController.validatePhonenumber(username,email,phoneNumber);
	}
	public void enterPassword(String  username,String emailId,String phoneNumber) {
		System.out.println("Enter Password:");
		String password = scanner.next();
		enterCourse(username, emailId,phoneNumber, password);
		
	}
	private void enterCourse(String username, String emailId, String phoneNumber, String password) {
		System.out.println("Enter Course ID:");
		String courseId = scanner.next();
		adminController.addTrainer(username, emailId,phoneNumber, password,courseId);
		
		
	}
	/* -------------INVALID Details Handling----------*/ 
	@Override
	public void invalidEmail(String username) {
		System.err.println("Invalid Email");
		enterMail(username);
		
	}
	@Override
	public void invalidPhone(String username,String email) {
		System.err.println("Invalid Phone number");
		enterPhonenumber(username,email);
		
	}
	@Override
	public void invalidOption(String errMsg) {
		System.out.println(errMsg);
		adminOptions();
		
	}
	/*------------CHNAGE TRAINER ------------*/
	@Override
	public void changeTrainer() {
		System.out.println("Enter Trainer ID:");
		String trainerId  = scanner.next();
		System.out.println("Enter Course ID:");
		String courseId = scanner.next();
		adminController.changeTrainer(trainerId,courseId);
		
		
	}
	/*---------------------Trainer Details-------------*/
	@Override
	public void trainerDetails(String trainerId, String trainerName, String email, String phoneNumber,HashMap<String,String> courses) {
		System.out.println("------------------Trainer Details<--------------------------------");
		System.out.println("Trainer ID  :  "+trainerId+"\t\tEmail  : "+email);
		System.out.println("Trainer Name  :  "+trainerName+"\t\tPhone Number  :  "+phoneNumber);
		System.out.println("Course ID\t\tCourse Name");
		System.out.println("-------------------------");
		Set<String> keys = courses.keySet();
		for(String key:keys) {
			System.out.println(key+"\t\t"+courses.get(key));
		}
		System.out.println();
		adminOptions();
	}
	@Override
	public void CourseDetails() {
		System.out.println("Enter Course ID:");
		String courseId =scanner.next();
		adminController.getCourse(courseId);
		
	}

	@Override
	public void showCourse(String courseId, String courseName, int cost, long courseIncome, long duration, LocalDate startDate,
			LocalTime localTime, LocalDate endDate, LocalTime endTime, int studentNo,
			String trainerId, String trainerName) {
		System.out.println("---------->Course Details<----------");
		System.out.println("Course ID : "+courseId +"\t\tStart Date : "+startDate);
		System.out.println("Course Name : "+courseName+"\t\tEnd Date : "+endDate);
		System.out.println("Trainer ID : "+trainerId+"\t\tDuration : "+duration );
		System.out.println("Trainer Name : "+trainerName +"\t\tNo of Students : "+studentNo);
		adminOptions();
	}
	@Override
	public void courseToRemove(String courseId, String courseName, int cost, long courseIncome, long duration,
			LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, int studentNo,
			String trainerId, String trainerName) {
		System.out.println("---------->Course Details<----------");
		System.out.println("Course ID : "+courseId +"\t\tStart Date : "+startDate);
		System.out.println("Course Name : "+courseName+"\t\tEnd Date : "+endDate);
		System.out.println("Trainer ID : "+trainerId+"\t\tDuration : "+duration );
		System.out.println("Trainer Name : "+trainerName +"\t\tNo of Students : "+studentNo);
		System.out.println("\n Press ok   to  Remove");
		String confirm  = scanner.next();
		adminController.removeCourse(confirm,courseId);
		
		
	}
	@Override
	public void removeSuccess() {
		System.out.println("Course Removed\n");
		adminOptions();
		
	}
	@Override
	public void changeTrainerSuccess() {
		System.out.println("Trainer Changed Successfully");
		adminOptions();
		
	}
	
	
	



	


}
