package com.sts.JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.JPA.dao.UserRepo;
import com.sts.JPA.entities.User;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(JpaApplication.class, args);
		UserRepo repo = context.getBean(UserRepo.class);
		User u = new User();
		u.setFirstname("arush");
		u.setCity("Chitrakoot Dham");
		u.setStatus("Active");
		
		System.out.println(repo.save(u));
		
	}

}
