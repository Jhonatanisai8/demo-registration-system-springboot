package com.isai.demoregistrationsystem.app.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "students")
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    private String codeStudent;
    private String dni;
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private String gender;
    private String email;
    private String phoneNumber;
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRegistration;

    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_legal_representative",
            referencedColumnName = "idLegalRepresentative",
            nullable = false)
    private LegalRepresentative legalRepresentative;

}
