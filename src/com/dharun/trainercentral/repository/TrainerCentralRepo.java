package com.dharun.trainercentral.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.dharun.course.dto.*;

public class TrainerCentralRepo {
	private HashSet<Student> students = new HashSet<>();
	private HashSet<Teacher> trainers = new HashSet<>();
	private List<Credential> credentials = new ArrayList<>();
	private HashSet<Course> courses = new HashSet<>();
	private static TrainerCentralRepo trainerCentralDb;

	private TrainerCentralRepo() {

	}

	public static TrainerCentralRepo getInstance() {
		if (trainerCentralDb == null) {
			trainerCentralDb = new TrainerCentralRepo();
			trainerCentralDb.initialSetup();
		}
		return trainerCentralDb;
	}

	private void initialSetup() {
		studentSetup();
		credentialSetup();
		courseSetup();
	}

	private void studentSetup() {
		students.add(new Student("STD001", "dharun", "vjdharanish@gmail.com", "9344124451"));
		students.add(new Student("STD002", "rajee", "rajee@gmail.com", "9344211231"));
	}

	private void credentialSetup() {
		credentials.add(new Credential("STD001", "dharun", "IamWaiting","student"));
		credentials.add(new Credential("STD002", "rajee", "rajee","student"));
		credentials.add(new Credential("TID001", "Akshaya", "akshaya","trainer"));
		credentials.add(new Credential("TID002", "madhi", "madhi","trainer"));
	}
	

	private void courseSetup() {
		Teacher trainer1 = new Teacher("TID001", "Akshaya", "akshaya@gmail.com", "7876545611");
		trainers.add(trainer1);
		Course course1 =new Course("CID001", "Java", "2023-01-01", 6, 0, trainer1, 0, 2000, "10:00", "12:00");
		courses.add(course1);
		trainer1.setCourse(course1);
		Teacher trainer2 = new Teacher("TID002", "Madhivadhani", "mathi@gmail.com", "8767865441");
		trainers.add(trainer2);
		Course course2 = new Course("CID002", "HTML", "2023-02-01", 2, 0, trainer2, 0, 1000, "12:00", "14:00");
		trainer2.setCourse(course2);
		courses.add(course2);
	}

	public List<String> checkCredential(String username, String password) {
		for (Credential credential : credentials) {
			if (credential.getUserId().equals(username) && credential.getPassword().equals(password)) {
				List<String> arr = new ArrayList<>();
				
				arr.add(credential.getUserId());
				arr.add(credential.getUsername());
				return arr;
			}
		}
		return null;
	}
	public Teacher checkCredential(String userId, String password, String category) {
		for (Credential credential : credentials) {
			if (credential.getUserId().equals(userId) && credential.getPassword().equals(password)&& credential.getCategory().equals(category)) {
				for(Teacher trainer:trainers) {
					if(trainer.getTrainerId().equals(userId)) {
						
						return trainer;
					}
				}
				
			}
		}
		return null;
	}
	

	public boolean verifyAdmin(String username, String password) {
		if (username.equals("admin") && password.equals("admin123"))
			return true;
		return false;
	}

	public Student addStudent(String studentId, String username, String emailId, String phoneNumber, String password) {
		
		Student student = new Student(studentId, username, emailId, phoneNumber);
		if(students.contains(student))
			return null;
		students.add(student);
		credentials.add(new Credential(studentId, username, password,"student"));
		return student;
	}

	public Teacher addTrainer(String trainerId, String username, String emailId, String phoneNumber, String password,
			String courseId) {
		
//		
		Course course = getCourse(courseId);
		if(course == null) return null;
		Teacher trainer = new Teacher(trainerId, username, emailId, phoneNumber, course);
		if(trainers.contains(trainer)) return null;	
		trainers.add(trainer);
		credentials.add(new Credential(trainerId, username, password,"trainer"));
		return trainer;
	}

	public Course getCourse(String courseId) {
		for (Course course : courses) {
			if (course.getCourseId().equals(courseId)) {
				return course;
			}
		}
		return null;
	}

	public Teacher getTrainer(String trainerId) {
		for (Teacher trainer : trainers) {
			if (trainer.getTrainerId().equals(trainerId))
				return trainer;
		}
		return null;
	}

	public Course addCourse(String courseId, String courseName, String startDate, long duration, int cost,
			String startTime, String endTime, Teacher trainer) {
		Course course =new Course(courseId,courseName,startDate,duration,0,trainer,0,cost,startTime,endTime);
		courses.add(course);
		trainer.setCourse(course);
		return course;
	}

	public boolean removeCourse(String courseId) {
		for(Course course:courses) {
			if(course.getCourseId().equals(courseId)) {
				courses.remove(course);
				return true;
			}	
		}
		return false;		
	}

	public boolean changeTrainer(String trainerId, String courseId) {
		for(Course course:courses) {
			if(course.getCourseId().equals(courseId)) {
				
				for(Teacher trainer:trainers) {
					if(trainer.getTrainerId().equals(trainerId)) {
						Teacher prevTrainer = course.getTrainer();
						   course.setTrainer(trainer);
						   trainer.setCourse(course);
						   prevTrainer.getCourse().remove(course);
						   return true;
					}
				}
				return false;
			}	
		}
		return false;
	}

	public HashSet<Course> getCourses() {
		return courses;
	}

	public Course joinCourse(String userId, int amount, Course course) {
		for(Student student : students) {
			if(student.getStudentId().equals(userId)) {
				if(student.getCourses().contains(course))
					return null;
				else {
					course.setStudentList(student);
					course.setStudentNo(course.getStudentNo()+1);
					
					course.setCourseIncome(course.getCourseIncome()+amount);
					student.setCourses(course);
					break;
					
				}
			}
		}
		
		return course;
		
	}

	public HashSet<Course> getEnrolledCourses(String userId) {
		for(Student student:students) {
			if(student.getStudentId().equals(userId)) {
				return student.getCourses();
			}
		}
		return null;
	}
	

}
