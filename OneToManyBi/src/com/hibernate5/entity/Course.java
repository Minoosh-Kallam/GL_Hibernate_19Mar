package com.hibernate5.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String courseName ;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Student student ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course(int id, String courseName, Student student) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.student = student;
	}

	public Course(String courseName, Student student) {
		super();
		this.courseName = courseName;
		this.student = student;
	}

	public Course() {
		super();
	}
	
	
	
}
