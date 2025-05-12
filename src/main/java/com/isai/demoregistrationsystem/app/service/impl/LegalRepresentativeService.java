package com.isai.demoregistrationsystem.app.service.impl;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import com.isai.demoregistrationsystem.app.repositorys.LegalRepresentativeRepository;
import com.isai.demoregistrationsystem.app.service.ILegalRepresentative;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LegalRepresentativeService
        implements ILegalRepresentative {
    private final LegalRepresentativeRepository legalRepresentativeRepository;

    @Override
    public void saveLegalRepresentative(LegalRepresentative legalRepresentative) {
        legalRepresentativeRepository.save(legalRepresentative);
    }

    @Override
    public Page<LegalRepresentative> findAll(Pageable pageable) {
        return legalRepresentativeRepository.findAll(pageable);
    }

    public List<LegalRepresentative> legalRepresentatives() {
        return legalRepresentativeRepository.findAll();
    }

    @Override
    public LegalRepresentative findById(Long id) {
        return legalRepresentativeRepository.findById(id).orElseThrow();
    }
}
