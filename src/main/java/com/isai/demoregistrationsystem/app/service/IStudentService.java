package com.isai.demoregistrationsystem.app.service;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import com.isai.demoregistrationsystem.app.models.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    void saveStudent(Student student);

    List<Student> listAllStudents();

    Page<Student> findAll(Pageable pageable);
}
