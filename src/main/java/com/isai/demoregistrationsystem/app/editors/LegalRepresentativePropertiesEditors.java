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
    public void setAsText(String id) throws IllegalArgumentException {
        if (id != null && !id.isEmpty()) {
            try {
                Long idLegalRepresentativeBD = Long.parseLong(id);
                LegalRepresentative legalRepresentative = serviceLegalRepresentative.findById(idLegalRepresentativeBD);
                this.setValue(legalRepresentative);
            } catch (NumberFormatException e) {
                setValue(null);
            }
        }
    }
}
