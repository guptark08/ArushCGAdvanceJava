package com.SpringLearn.SpringProgramDiUsingConstructorByJavaClass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringLearn.beans.Address;
import com.SpringLearn.beans.Student;

@Configuration
public class SpringConfigFile {

	@Bean
	public Address add() {
		Address ad = new Address(5, "Lucknow", 226016);
		return ad;
	}

	@Bean
	public Student stu() {
		Student st = new Student("Arush", "Gupta", add());
		return st;
	}
}
