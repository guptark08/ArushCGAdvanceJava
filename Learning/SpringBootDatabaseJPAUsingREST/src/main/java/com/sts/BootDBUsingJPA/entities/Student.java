package com.sts.BootDBUsingJPA.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int rollNo;
	private String firstName;
	private String lastName;
	private String address;
	private boolean status;

	public int getId() {
		return id;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Student(int rollNo, String firstName, String lastName, String address, boolean status) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.status = status;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", status=" + status + "]";
	}

}
