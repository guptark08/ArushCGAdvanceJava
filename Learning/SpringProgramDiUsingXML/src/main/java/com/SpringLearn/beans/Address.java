package com.SpringLearn.beans;

public class Address {

	private int houseNo;
	private String city;
	private int pincode;

	public int getHouseNo() {
		return houseNo;
	}

	public String getCity() {
		return city;
	}

	public int getPincode() {
		return pincode;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
