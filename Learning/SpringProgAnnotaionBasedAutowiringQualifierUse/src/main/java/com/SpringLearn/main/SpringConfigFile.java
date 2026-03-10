package com.SpringLearn.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringLearn.beans.Address;
import com.SpringLearn.beans.Student;

@Configuration
public class SpringConfigFile {

	@Bean
	public Address add() {
		Address a = new Address();
		a.setCity("Lucknow");
		return a;
	}
	@Bean
	public Address add2() {
		Address a = new Address();
		a.setCity("Chitrakoot");
		return a;
	}
	
	@Bean
	public Student stu() {
		Student s = new Student();
		s.setName("Arush");
		return s;
	}
	
}
