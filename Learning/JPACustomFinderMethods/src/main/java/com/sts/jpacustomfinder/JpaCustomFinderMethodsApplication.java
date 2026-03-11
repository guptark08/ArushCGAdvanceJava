package com.sts.jpacustomfinder;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.jpacustomfinder.dao.StudentRepository;
import com.sts.jpacustomfinder.entities.Student;

@SpringBootApplication
public class JpaCustomFinderMethodsApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaCustomFinderMethodsApplication.class, args);
		StudentRepository stu = context.getBean(StudentRepository.class);
		List<Student> byCity = stu.findByCity("Lucknow");
		byCity.forEach(x -> System.out.println(x.getFirstName()));
		
		List<Student> byFirstNameAndCity = stu.findByFirstNameAndCity("Arush", "Lucknow");
		byFirstNameAndCity.forEach(x-> System.out.println(x));
		
	}

}
