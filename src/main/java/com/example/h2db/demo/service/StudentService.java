package com.example.h2db.demo.service;

import com.example.h2db.demo.model.Student;

import java.util.*;

public interface StudentService {

    Student createStudent(Student student);

    Student updateStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(long studentId);

    void deleteStudent(long Id);

}
