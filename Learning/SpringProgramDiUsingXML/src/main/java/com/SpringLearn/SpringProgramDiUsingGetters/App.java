package com.SpringLearn.SpringProgramDiUsingGetters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringLearn.beans.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student s = (Student) context.getBean("stu");
		System.out.println(s);
	}
}
