package com.sts.JPACRUD.dao;

import org.springframework.data.repository.CrudRepository;

import com.sts.JPACRUD.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{}