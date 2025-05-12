package com.isai.demoregistrationsystem.app.service;

import com.isai.demoregistrationsystem.app.models.entities.Student;

import java.util.List;

public interface IStudentService {
    void saveStudent(Student student);

    List<Student> listAllStudents();
}
