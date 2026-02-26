package com.SpringLearn.beans;

public class Student {

	private String fName;
	private int rollNo;
	private Address address;

	public String getfName() {
		return fName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public Address getAddress() {
		return address;
	}
	
	

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
