package com.SpringLearn.beans;

public class Student {

	private String fName;
	private int rollNo;
	private Address address;

	public Student(String fName, int rollNo, Address address) {
		super();
		this.fName = fName;
		this.rollNo = rollNo;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", rollNo=" + rollNo + ", address=" + address + "]";
	}
	
	

}
