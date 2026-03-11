package com.sts.jpacustomfinder.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String firstName;
	private String city;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student() {
	}

	public Student(int id, String firstName, String city, String address) {
		this.id = id;
		this.firstName = firstName;
		this.city = city;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", city=" + city + ", address=" + address + "]";
	}
}