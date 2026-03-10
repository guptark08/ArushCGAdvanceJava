package com.SpringLearn.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

	private String fName;
	private int rollNo;
	
	@Autowired
	private Address address;

	

	public void setfName(String fName) {
		this.fName = fName;
	}



	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Student [fName=" + fName + ", rollNo=" + rollNo + ", address=" + address + "]";
	}
	
	

}
