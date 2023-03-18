package com.hibernate3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@Column(name = "f_name")
	public String firstName;
	
	@Column(name = "l_name")
	public String lastName ;
	
	public String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String name) {
		this.email = name;
	}

	public Teacher(int id, String firstName, String lastName, String name) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = name;
	}

	public Teacher(String firstName, String lastName, String name) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = name;
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
	
}
