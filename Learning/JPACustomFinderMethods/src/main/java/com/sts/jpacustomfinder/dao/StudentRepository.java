package com.sts.jpacustomfinder.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sts.jpacustomfinder.entities.Student;

// Derived Query Methods 
public interface StudentRepository extends CrudRepository<Student, Integer> {

	// this is the customer finder methods by default
	public List<Student> findByFirstName(String firstName);

	public List<Student> findByAddress(String address);

	public List<Student> findByCity(String city);

	public List<Student> findById(int id);
	
//	 Query Creation methods custom
	
	List<Student> findByFirstNameAndCity(String firstName, String city);
	
//	more type - https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}
