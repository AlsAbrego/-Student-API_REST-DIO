package com.studentbooks.student.services;

import com.studentbooks.student.entities.Student;
import com.studentbooks.student.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;
    
    // @Autowired
    // public StudentService(StudentRepository studentRepository) {
    //     this.studentRepository = studentRepository;
    // }

    public String create(Student student) {
        Student savedStudent = studentRepository.save(student);
        return "Student Created with sucess, with ID: " + savedStudent.getId();
    }
    
}
