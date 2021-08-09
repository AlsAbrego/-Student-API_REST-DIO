package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import services.StudentService;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final StudentService studentService;

    
    
}
