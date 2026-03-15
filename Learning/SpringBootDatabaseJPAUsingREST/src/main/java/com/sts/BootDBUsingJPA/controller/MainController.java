package com.sts.BootDBUsingJPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.BootDBUsingJPA.entities.Student;
import com.sts.BootDBUsingJPA.services.StudentServices;

@RestController
public class MainController {

	@Autowired
	private StudentServices stuServices;

//	CRUD - Create, Read, Update, Delete
//	READ------------------------------------------------------
//	get all methods 
	@GetMapping("/allstudents")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudent = stuServices.getAllStudent();
		if (allStudent.isEmpty()) {
			return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).build();
		}
		return ResponseEntity.of(Optional.of(allStudent));
	}

//	get student by id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		Student stu = stuServices.getStudentById(id);
		if (stu == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(stu));
	}

//	CREATE-----------------------------------------------------
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student studentDetail) {
		Student stu = stuServices.addStudent(studentDetail);
		return ResponseEntity.status(HttpStatus.CREATED).body(stu);
	}

//	UPDATE-----------------------------------------------------
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student stu, @PathVariable int id) {
		Student updateStudent = stuServices.updateStudent(stu, id);
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(updateStudent);
	}

//	DELETE-----------------------------------------------------
	@DeleteMapping("/students/{id}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable int id) {
		List<Student> remStudent = stuServices.deleteStudent(id);
		if (remStudent.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(remStudent));
	}
}