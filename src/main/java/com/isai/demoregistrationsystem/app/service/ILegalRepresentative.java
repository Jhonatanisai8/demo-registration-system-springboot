package com.isai.demoregistrationsystem.app.service;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILegalRepresentative {
    void saveLegalRepresentative(LegalRepresentative legalRepresentative);

    Page<LegalRepresentative> findAll(Pageable pageable);

    LegalRepresentative findById(Long id);
}
