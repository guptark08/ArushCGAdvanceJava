package com.sts.BootREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.BootREST.entities.Student;
import com.sts.BootREST.services.StudentService;

@RestController
public class MainController {

	@Autowired
	private StudentService StudentService;

	@GetMapping("/test")
	public Student test() {
		return new Student(101, "Arush", "Lucknow");
	}

	@GetMapping("/Students")
	public List<Student> getAllStudent() {
		return StudentService.getAllStudents();
	}

	@GetMapping("/Student/{id}")
	public Student getById(@PathVariable("id") int id) {
		return StudentService.getStudentById(101);
	}

	@PostMapping("/Student")
	public Student AddStudent(@RequestBody Student student) {
		StudentService.addStudent(student);
		return student;
	}
	
	@DeleteMapping("/Student/{id}")
	public List<Student> deleteStudent(@PathVariable("id") int Id) {
		return StudentService.deleteStudent(Id);
	}
	
	@PutMapping("/Student/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("id") int StudentId) {
		return StudentService.updateStudent(student, StudentId);
	}

}
