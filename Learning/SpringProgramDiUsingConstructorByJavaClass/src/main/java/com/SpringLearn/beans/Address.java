package com.SpringLearn.beans;

public class Address {
	private String city;
	private int houseNo,pincode;
	public Address(int houseNo, String city, int pincode) {
		super();
		this.houseNo = houseNo;
		this.city = city;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
}
