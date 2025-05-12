package com.isai.demoregistrationsystem.app.repositorys;

import com.isai.demoregistrationsystem.app.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

}
