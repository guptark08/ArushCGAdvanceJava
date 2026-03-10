package com.SpringLearn.beans;

public class Student {

	private String name;

	private Address address;

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + "]";
	}
	
	

}
