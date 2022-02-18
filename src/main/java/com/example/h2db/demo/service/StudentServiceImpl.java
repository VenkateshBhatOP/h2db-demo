package com.example.h2db.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.h2db.demo.exception.ResourceNotFoundException;
import com.example.h2db.demo.model.Student;
import com.example.h2db.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return this.studentRepository.save(student);

    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> studentDb = this.studentRepository.findById(student.getId());

        if (studentDb.isPresent()) {
            Student studentUpdate = studentDb.get();
            studentUpdate.setId(student.getId());
            studentUpdate.setName(student.getName());
            studentUpdate.setAddress(student.getAddress());

            return this.studentRepository.save(studentUpdate);

        } else {
            throw new ResourceNotFoundException("Student ID not found in DB for : " + student.getId());
        }

    }

    @Override
    public List<Student> getAllStudents() {

        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long studentId) {
        Optional<Student> studentDb = this.studentRepository.findById(studentId);

        if (studentDb.isPresent()) {
            return studentDb.get();
        } else {
            throw new ResourceNotFoundException("Student ID not found in DB for : " + studentId);

        }
    }

    @Override
    public void deleteStudent(long Id) {
        Optional<Student> studentDb = this.studentRepository.findById(Id);

        if (studentDb.isPresent()) {
            this.studentRepository.delete(studentDb.get());
        } else {
            throw new ResourceNotFoundException("Student ID not found in DB for : " + Id);

        }

    }

}
