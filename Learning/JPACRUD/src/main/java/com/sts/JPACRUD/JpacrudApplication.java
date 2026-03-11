package com.sts.JPACRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.JPACRUD.dao.StudentRepo;
import com.sts.JPACRUD.entities.Student;

@SpringBootApplication
public class JpacrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpacrudApplication.class, args);
		StudentRepo stuRepo = context.getBean(StudentRepo.class);

//		Single object insertion
//		Student stu = new Student("Arush", "Lucknow", "Indira Nagar");

//		multiple object insertion
//		List<Student> a = new ArrayList<>();
//		a.add(new Student("Aviral", "Chitrakoot Dham", "Karwi"));
//		a.add(new Student("Archit", "St Thomas", "Kerla"));

//		System.out.println(stuRepo.saveAll(a));

//		a.forEach(x -> System.out.println(a));

//		updating user by id 
//		Optional<Student> foundStudent = stuRepo.findById(1);
//		if (foundStudent.isPresent()) {
//			Student s = foundStudent.get();
//			s.setFirstName("Arush Gupta");
//			stuRepo.save(s);
//		}
		
//		get all the data present in the DB
		
//		Iterable<Student> all = stuRepo.findAll();
//		all.forEach(x-> System.out.println(x));
//		stuRepo.save(new Student("Arush", "Lucknow", "Ashiyana Colony"));
		
	}

}
