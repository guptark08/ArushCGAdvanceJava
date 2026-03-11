package com.sts.ExecutingJPQL;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.ExecutingJPQL.dao.StudentRepo;
import com.sts.ExecutingJPQL.entities.Student;

@SpringBootApplication
public class ExecutingJpqlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ExecutingJpqlApplication.class, args);
		StudentRepo stu = context.getBean(StudentRepo.class);
		List<Student> allUser = stu.getAllUser();
//		allUser.forEach(x -> System.out.println(x));

		List<Student> studentByName = stu.getStudentByName("Arush");
		studentByName.forEach(x -> System.out.println(x));
	}

}
