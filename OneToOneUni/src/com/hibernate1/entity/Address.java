package com.hibernate1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address1")
public class Address {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "addressId")
	private int addressId ;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state ;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "houseNo" )
	private String houseNo ;
	

	public Address(String country, String state, String city, String street, String houseNo) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.houseNo = houseNo;
	}

	public Address(int addressId, String country, String state, String city, String street, String houseNo) {
		super();
		this.addressId = addressId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.houseNo = houseNo;
	}

	public Address() {
		super();
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	
	
}
