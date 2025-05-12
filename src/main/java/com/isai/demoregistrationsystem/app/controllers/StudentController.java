package com.isai.demoregistrationsystem.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping(path = "/create-student")
    public String viewCreateStudent() {
        return "students/create-student";
    }
}
