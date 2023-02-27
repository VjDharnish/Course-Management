package com.dharun.course.login;
import java.util.List;

import java.util.Scanner;

import com.dharun.course.admin.AdminView;
import com.dharun.course.dto.Course;
import com.dharun.course.enrollment.EnrollView;

public class LoginView implements  LoginViewCallBack ,LoginSignupCallBack{
	private LoginControllerCallBack loginController;
	private Scanner sc = new Scanner(System.in);
   
	public LoginView() {
		loginController = new LoginController(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView loginView = new LoginView();
		loginView.init();
		

	}
	public void  init() {
		System.out.println("---> Welcome to Trainer Central  <---");
		System.out.println("--------------------------------------");
		System.out.println("1. Student Login");
		System.out.println("2. Student Signup");
		System.out.println("3. Trainer Login");
		System.out.println("4. Admin Login");
		System.out.println("5.  Exit");
		System.out.println("Enter the option");
		char option = sc.next().charAt(0);
		loginController.loginOptions(option);
		
		
	}
	@Override
	public void studentLogin() {
		System.out.println("Enter your Student ID:");
		String username = sc.next();
		System.out.println("Enter your Password:");
		String password = sc.next();
		loginController.checkStudent(username, password);
		
	}
	@Override
	public void studentSignup() {
		System.out.println("\nEnter details\n");
		System.out.println("Enter UserName:");
		String  username= sc.next();	
		enterMail(username);
		
	}
	private void enterMail(String username) {
		System.out.println("Enter Email Id");
		String emailId = sc.next();
		loginController.validateEmail(username,emailId);
		
		
	}
	public void enterPhonenumber(String username,String email) {
		System.out.println("Enter Phone Number:");
		String phoneNumber = sc.next();
		loginController.validatePhonenumber(username,email,phoneNumber);
	}
	public void enterPassword(String  username,String emailId,String phoneNumber) {
		System.out.println("Enter Password:");
		String password = sc.next();
		loginController.addStudent(username, emailId,phoneNumber, password);
		
	}
	
	@Override
	public void trainerLogin() {
		System.out.println("Enter your Trainer ID:");
		String username = sc.next();
		System.out.println("Enter your Password:");
		String password = sc.next();
		loginController.checkTrainer(username, password);
	}
	@Override
	public void adminLogin() {
		System.out.println("Enter your Admin Name:");
		String username = sc.next();
		System.out.println("Enter your Password:");
		String password = sc.next();
		loginController.checkAdmin(username, password);
		
		
	}
	@Override
	public void exit() {
		System.out.println("THANK YOU VISIT AGAIN ");
		System.exit(0);
	}
	@Override
	public void invalidOption(String errMsg) {
		System.out.println(errMsg);
		init();
		
	}
	@Override
	public void verifiedStudent(List<String> name) {
		System.out.println("Hello "+ name.get(1)+ " !");
		EnrollView enrollView  = new EnrollView(this,name.get(0));
		enrollView.enrollOptions();	
	}
	@Override
	public void adminVerified() {
		System.out.println("Admin Verified\n");
		AdminView adminView = new AdminView(this);
		adminView.adminOptions();
		
		
		
	}
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
	public void signupSuccess(String userId) {
		System.out.println("Signup Successful");
		System.out.println("Your Student Id---" + userId);
		init();		
	}
	@Override
	public void verifiedTrainer(String trainerId, String trainerName, String email, String phoneNumber,
			List<Course> courses) {
		System.out.println("Your Profile");
		System.out.println("Trainer ID : " +trainerId+"\tEmail : "+email);
		System.out.println("Trainer Name : "+trainerName+"\tPhone Number : "+phoneNumber);
		System.out.println("Courses");
		
		for(Course course:courses) {
			System.out.println(course.getCourseId() +"\t"+course.getCourseName());
		}
		
		init();
		
	}
	

}
