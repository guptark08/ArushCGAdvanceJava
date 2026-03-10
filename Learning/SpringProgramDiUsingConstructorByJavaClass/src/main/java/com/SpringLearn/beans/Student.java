package com.SpringLearn.beans;

public class Student {
	private String fName, lName;
	private Address address;

	public Student(String fName, String lName, Address address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", address=" + address + "]";
	}

}
