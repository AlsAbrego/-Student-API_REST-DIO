package com.studentbooks.student.controllers;


import java.util.List;

import javax.validation.Valid;

import com.studentbooks.student.dto.request.StudentDTO;
import com.studentbooks.student.dto.response.MessageResponseDTO;
import com.studentbooks.student.entities.Student;
import com.studentbooks.student.exception.StudentNotFoundException;
import com.studentbooks.student.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public MessageResponseDTO createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return studentService.create(studentDTO);
    }


    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.findAll();        
    }

    
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) throws StudentNotFoundException {
        return studentService.update(id, studentDTO);        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.delete(id);
    }
    

}
