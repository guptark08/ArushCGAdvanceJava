package com.sts.BootREST.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sts.BootREST.entities.Student;

@Component
public class StudentService {

	private static List<Student> student = new ArrayList<>();
	static {
		student.add(new Student(101, "Arush", "Lucknow"));
		student.add(new Student(102, "Aviral", "Chitrakoot Dham"));
	}

	public List<Student> getAllStudents() {
		return student;
	}

	public Student getStudentById(int id) {
		return student.stream().filter(x -> x.getId() == id).findFirst().get();
	}

	public void addStudent(Student stu) {
		student.add(stu);
	}

	public List<Student> deleteStudent(int id) {
		if (student.contains(id)) {
			student.remove(id);
		}
		return student;
	}

	public Student updateStudent(Student s, int id) {
		for (Student x : student) {
			if (x.getId() == id) {
				x.setCity(s.getCity());
				x.setName(s.getName());
				return x;
			}
		}
		return null;
	}
}
