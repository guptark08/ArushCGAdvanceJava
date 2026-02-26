package com.SpringLearn.beans;

public class Student {

	private String fName;
	private int rollno;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public void display() {
		System.out.println(getfName());
		System.out.println(getRollno());
	}
}
