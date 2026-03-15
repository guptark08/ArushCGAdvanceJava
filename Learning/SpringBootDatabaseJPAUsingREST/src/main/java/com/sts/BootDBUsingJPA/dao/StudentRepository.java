package com.sts.BootDBUsingJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.BootDBUsingJPA.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByFirstName(String firstName);

    public Student findByRollNo(int rollNo);

    public List<Student> findByStatus(boolean status);

    public List<Student> findByAddress(String address);
}