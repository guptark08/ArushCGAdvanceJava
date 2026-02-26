package com.SpringLearn.SpringProgramDiUsingSetterByJavaClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringLearn.beans.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		Student s = context.getBean(Student.class);
		System.out.println(s);

	}
}
