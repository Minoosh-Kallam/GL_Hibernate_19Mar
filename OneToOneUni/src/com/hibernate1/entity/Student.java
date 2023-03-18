package com.hibernate1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student1")
public class Student {

	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	@Id
	private int id;
	
	@Column(name = "studentName")
	private String name ;
	
	@Column(name = "rollNo")
	private String rollNo ;
	
	@OneToOne(cascade = { CascadeType.ALL , CascadeType.REMOVE}, fetch = FetchType.LAZY )
	@JoinTable(name = "address_id1")
	private Address address ;
	

	public Student(String name, String rollNo, Address address) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	public Student() {
		super();
	}

	public Student(int id, String name, String rollNo, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
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

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", address=" + address + "]";
	}
	
}
