package com.sts.ExecutingJPQL.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sts.ExecutingJPQL.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
// this is JPQL
	@Query("Select s from Student s")
	public List<Student> getAllUser();

//	Parameterized Query 
	@Query("select s from Student s where s.FirstName = :n")
	public List<Student> getStudentByName(@Param("n") String name);

//	Native Query this is our mysql query
	@Query(value = "Select * from Student", nativeQuery = true)
	public List<Student> getusers();
}