package com.SpringLearn.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.SpringLearn.beans.Student;

@Configuration
public class SpringConfigFile {

    @Bean
    public Student StdId() {
        Student std = new Student();
        std.setfName("Arush");
        std.setRollno(1);
        return std;
    }
}