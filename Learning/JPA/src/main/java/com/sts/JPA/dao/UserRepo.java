package com.sts.JPA.dao;

import org.springframework.data.repository.CrudRepository;

import com.sts.JPA.entities.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	
}
