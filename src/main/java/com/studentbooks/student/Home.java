package com.studentbooks.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {
    
    @GetMapping
    public String getHi() {
        return "It's on!!";
    }
}
