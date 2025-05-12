package com.isai.demoregistrationsystem.app.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    private String codeStudent;
    private String dni;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dateRegistration;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Legal_representative")
    private LegalRepresentative legalRepresentative;

}
