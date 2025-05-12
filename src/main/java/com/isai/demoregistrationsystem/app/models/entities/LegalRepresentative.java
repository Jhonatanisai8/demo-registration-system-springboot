package com.isai.demoregistrationsystem.app.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "segal_representative")
public class LegalRepresentative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLegalRepresentative;
    private String firstName;
    private String lastName;
    private String dni;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String relationship;
}
