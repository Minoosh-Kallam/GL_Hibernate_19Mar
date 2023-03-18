package com.hibernate4.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	String designation ;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL , CascadeType.REFRESH})
	@JoinTable(name = "employee_project_id" )
	List<Project> projects ;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", projects=" + projects
				+ "]";
	}

	public Employee(int id, String name, String designation, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.projects = projects;
	}

	public Employee(String name, String designation, List<Project> projects) {
		super();
		this.name = name;
		this.designation = designation;
		this.projects = projects;
	}

	public Employee() {
		super();
	}
	
	
	
}
