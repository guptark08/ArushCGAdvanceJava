package com.SpringLearn.beans;

public class Address {
	
	private String city;

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
	
	

}
