package com.isai.demoregistrationsystem.app.controllers;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import com.isai.demoregistrationsystem.app.models.entities.Student;
import com.isai.demoregistrationsystem.app.service.impl.LegalRepresentativeService;
import com.isai.demoregistrationsystem.app.service.impl.StudentService;
import com.isai.demoregistrationsystem.app.utils.pagination.PageRender;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final LegalRepresentativeService legalRepresentativeService;

    @GetMapping(path = "")
    public String showStudents(@RequestParam(name = "page", defaultValue = "0") int page,
                               Map<String, Object> model) {
        model.put("titleList", "Lista de Estudiantes");
        Pageable pageable = PageRequest.of(page, 15);
        Page<Student> students = studentService.findAll(pageable);
        PageRender<Student> pageRender = new PageRender<>("/student", students);
        model.put("students", students);
        model.put("page", pageRender);
        return "students/show-students";
    }

    @GetMapping(path = "/create")
    public String viewCreateStudent() {
        return "students/create-student";
    }

    @ModelAttribute("legalRepresentativeServices")
    public List<LegalRepresentative> legalRepresentativeServices() {
        return legalRepresentativeService.legalRepresentatives();
    }
}
