package com.SpringLearn.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringLearn.beans.Student;

public class main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		Student s = context.getBean(Student.class);
		System.out.println(s);
	}
}
