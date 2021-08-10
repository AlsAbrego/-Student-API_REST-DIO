package com.studentbooks.student.services;

import java.util.List;

import com.studentbooks.student.entities.Student;
import com.studentbooks.student.exception.StudentNotFoundException;
import com.studentbooks.student.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;
 
    public String create(Student student) {
        Student savedStudent = studentRepository.save(student);
        return "Student Created with sucess, with ID: " + savedStudent.getId();
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) throws StudentNotFoundException{
        Student studentFind = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return studentFind;
    }
    
}
