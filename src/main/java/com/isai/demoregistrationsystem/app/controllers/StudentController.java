package com.isai.demoregistrationsystem.app.controllers;

import com.isai.demoregistrationsystem.app.editors.LegalRepresentativePropertiesEditors;
import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import com.isai.demoregistrationsystem.app.models.entities.Student;
import com.isai.demoregistrationsystem.app.service.impl.LegalRepresentativeService;
import com.isai.demoregistrationsystem.app.service.impl.StudentService;
import com.isai.demoregistrationsystem.app.utils.pagination.PageRender;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;
    private final LegalRepresentativeService legalRepresentativeService;
    private final LegalRepresentativePropertiesEditors editorLegalRepresentative;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //registramos el representante legal
        binder.registerCustomEditor(LegalRepresentative.class, "legalRepresentative", editorLegalRepresentative);
    }

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
    public String viewCreateStudent(Map<String, Object> model) {
        Student student = new Student();
        model.put("title", "Registro de Estudiantes");
        model.put("student", student);
        return "students/create-student";
    }

    @PostMapping(path = "/create")
    public String saveStudent(
            @Valid Student student,
            BindingResult result,
            Model model) {
        model.addAttribute("subtitle", "Registro de Estudiante");
        LOGGER.info("DATOS DEL FROM: {}", student);
        if (result.hasErrors()) {
            model.addAttribute("title", "Registro de Estudiantes");
            model.addAttribute("legalRepresentativeServices", legalRepresentativeServices());
            return "students/create-student";
        }
        studentService.saveStudent(student);
        System.out.println("SE GUARDO EL ESTUDIANTE");
        return "redirect:/students";
    }

    @ModelAttribute("legalRepresentativeServices")
    public List<LegalRepresentative> legalRepresentativeServices() {
        return legalRepresentativeService.legalRepresentatives();
    }
}
