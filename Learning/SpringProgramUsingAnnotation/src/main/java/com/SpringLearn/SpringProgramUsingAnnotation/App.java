package com.SpringLearn.SpringProgramUsingAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringLearn.beans.Student;

public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //Using XMl 
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class); //Using Class 
        Student s = (Student) context.getBean("student");
        s.display();
    }
}
