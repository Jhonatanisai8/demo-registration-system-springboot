package com.isai.demoregistrationsystem.app.repositorys;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalRepresentativeRepository
        extends JpaRepository<LegalRepresentative, Long> {
}
