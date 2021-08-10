package com.studentbooks.student.services;

import java.util.List;

import com.studentbooks.student.entities.Student;
import com.studentbooks.student.exception.StudentNotFoundException;
import com.studentbooks.student.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
// import net.bytebuddy.asm.Advice.Return;

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

    public String delete(Long id) throws StudentNotFoundException {
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.deleteById(id); 
        return "Student with ID: " + id +  " was deleted with success";              
    }

    public String update(Long id, Student student) throws StudentNotFoundException {
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        
        studentRepository.save(student);
        // Student studentUpdated = 

        return "Student sucessfully update with ID: " + id;
    }
    
}
