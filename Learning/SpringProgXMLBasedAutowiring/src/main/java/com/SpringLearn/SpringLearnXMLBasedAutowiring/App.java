package com.SpringLearn.SpringLearnXMLBasedAutowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringLearn.beans.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Student s = (Student) context.getBean("StdId");
        System.out.println(s);
    }
}
