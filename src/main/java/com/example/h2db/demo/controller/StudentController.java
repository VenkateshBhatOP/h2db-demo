package com.example.h2db.demo.controller;

import com.example.h2db.demo.model.Student;
import com.example.h2db.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/students/{Id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long Id) {
        return ResponseEntity.ok().body(studentService.getStudentById(Id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.createStudent(student));

    }

    @PutMapping("/students/{Id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long Id, @RequestBody Student student) {
        student.setId(Id);
        return ResponseEntity.ok().body(this.studentService.updateStudent(student));

    }

    @DeleteMapping("/students/{Id}")
    public HttpStatus deleteStudent(@PathVariable long Id) {
        this.studentService.deleteStudent(Id);
        return (HttpStatus.OK);
    }
}
