package com.dharun.course.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseId;
	private String courseName;
	private LocalDate startDate;
	private long duration;
	private LocalDate endDate;
	private int studentNo;
	private List<Student> studentList  = new ArrayList<>();
	private Teacher trainer;
	private long courseIncome;
	private int cost;
	private LocalTime startTime;
	private LocalTime endTime;
	public Course(String courseId,String courseName, String startDate, long duration, int studentNo,
			Teacher trainer, long courseIncome, int cost, String startTime, String endTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.startDate = LocalDate.parse(startDate);
		this.duration = duration;
		this.endDate = this.startDate.plusMonths(duration);
		this.studentNo = studentNo;
		this.trainer = trainer;
		this.courseIncome = courseIncome;
		this.cost = cost;
		this.startTime =LocalTime.parse(startTime); 
		this.endTime = LocalTime.parse(endTime); 
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(Student student) {
		this.studentList.add(student);
	}
	public Teacher getTrainer() {
		return trainer;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public void setTrainer(Teacher trainer) {
		this.trainer = trainer;
	}
	public long getCourseIncome() {
		return courseIncome;
	}
	public void setCourseIncome(long courseIncome) {
		this.courseIncome = courseIncome;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", startDate=" + startDate
				+ ", duration=" + duration + ", endDate=" + endDate + ", studentNo=" + studentNo + ", studentList="
				+ studentList + ", trainer=" + trainer + ", courseIncome=" + courseIncome + ", cost=" + cost
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
	
}
