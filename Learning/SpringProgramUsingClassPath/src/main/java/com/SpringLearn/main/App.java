package com.SpringLearn.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringLearn.beans.Student;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context =
    	        new AnnotationConfigApplicationContext(com.SpringLearn.resources.SpringConfigFile.class);
        Student st1 = (Student) context.getBean("StdId");
        st1.display();
        
    }
}
