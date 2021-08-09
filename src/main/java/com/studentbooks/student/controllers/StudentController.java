package com.studentbooks.student.controllers;


import java.util.List;

import com.studentbooks.student.entities.Student;
import com.studentbooks.student.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/student")
public class StudentController {
    
    private final StudentService studentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createStudent(@RequestBody Student student) {
        return studentService.create(student);
    }
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();        
    }

}
