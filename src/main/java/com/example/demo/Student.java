package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	//College college;
	@Column(name="rollno")
	private int rollno;
	@Column(name="qualification")
	private String qualification;
	@Column(name="course")
	private String course;
	@Column(name="year")
	private int year;
	//Certificate certificate;
//	@Column(name = "hall_ticket_no")
	@Column(name="hallTicketNo")
	private int hallTicketNo;
	public Student(int id, String name, int rollno, String qualification, String course, int year, int hallTicketNo) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.hallTicketNo = hallTicketNo;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHallTicketNo() {
		return hallTicketNo;
	}
	public void setHallTicketNo(int hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}
	
}
