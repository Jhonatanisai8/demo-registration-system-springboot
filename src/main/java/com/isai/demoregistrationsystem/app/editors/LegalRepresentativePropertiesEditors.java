package com.isai.demoregistrationsystem.app.editors;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import com.isai.demoregistrationsystem.app.service.impl.LegalRepresentativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
@RequiredArgsConstructor
public class LegalRepresentativePropertiesEditors
        extends PropertyEditorSupport {

    private final LegalRepresentativeService serviceLegalRepresentative;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Long idLegalRepresentativeBD = Long.parseLong(text);
        LegalRepresentative legalRepresentative = serviceLegalRepresentative.findById(idLegalRepresentativeBD);
        setValue(legalRepresentative);
    }
}
