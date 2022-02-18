package com.example.h2db.demo.repository;

import com.example.h2db.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
