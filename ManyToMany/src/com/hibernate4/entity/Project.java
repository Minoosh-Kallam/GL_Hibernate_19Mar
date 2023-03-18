package com.hibernate4.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(unique = true, nullable = false)
	int id ;
	
	String projectName ;
	
	@ManyToMany(mappedBy = "projects")
	List<Employee> employees ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project(int id, String projectName, List<Employee> employees) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.employees = employees;
	}

	public Project(String projectName, List<Employee> employees) {
		super();
		this.projectName = projectName;
		this.employees = employees;
	}
	
	public Project() {
		super();
	}
	
	
}
