package com.SpringLearn.SpringProgAnnotationBasedAutowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringLearn.beans.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        Student s = context.getBean(Student.class);
        System.out.println(s);
    }
}
