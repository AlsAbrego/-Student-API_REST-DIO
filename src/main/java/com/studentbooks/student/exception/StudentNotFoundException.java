package com.studentbooks.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(Long id) {
        super(String.format("Student with ID %s was NOT founded", id));
    }

    
    
}
