package com.isai.demoregistrationsystem.app.controllers;

import com.isai.demoregistrationsystem.app.models.entities.LegalRepresentative;
import com.isai.demoregistrationsystem.app.service.impl.LegalRepresentativeService;
import com.isai.demoregistrationsystem.app.utils.pagination.PageRender;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/legal-representative")
@RequiredArgsConstructor

public class LegalRepresentativeController {

    private final LegalRepresentativeService legalRepresentativeService;

    @GetMapping(path = "")
    public String showLegalRepresentatives(@RequestParam(name = "page", defaultValue = "0") int page,
                                           Map<String, Object> model) {
        model.put("titleList", "Lista de Representantes Legales");
        Pageable pageable = PageRequest.of(page, 15);
        Page<LegalRepresentative> legalRepresentatives = legalRepresentativeService.findAll(pageable);
        PageRender<LegalRepresentative> pageRender = new PageRender<>("/legal-representative", legalRepresentatives);
        model.put("legalRepresentatives", legalRepresentatives);
        model.put("page", pageRender);
        return "legal-representatives/show-legal-representatives";
    }

    // Vista para registrar nuevo representante legal
    @GetMapping("/create")
    public String viewCreateForm(Map<String, Object> model) {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        model.put("legalRepresentative", legalRepresentative);
        model.put("formAction", "/legal-representative/save"); // Usamos una sola acción POST para ambos casos
        model.put("title", "Registrar Representante Legal");
        model.put("subtitle", "Nuevo Representante Legal");
        return "legal-representatives/create-legal-representative";
    }

    // Vista para editar un representante existente
    @GetMapping("/edit/{id}")
    public String viewEditForm(@PathVariable("id") Long id, Map<String, Object> model) {
        LegalRepresentative legalRepresentative = legalRepresentativeService.findById(id);
        model.put("legalRepresentative", legalRepresentative);
        model.put("formAction", "/legal-representative/save"); // misma acción POST
        model.put("title", "Editar Representante Legal");
        model.put("subtitle", "Modificar Representante Legal");
        return "legal-representatives/create-legal-representative";
    }

    // Guarda o actualiza según si el ID existe o no
    @PostMapping("/save")
    public String saveLegalRepresentative(
            @Valid @ModelAttribute("legalRepresentative") LegalRepresentative legalRepresentative,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("formAction", "/legal-representative/save");
            model.addAttribute("title", legalRepresentative.getIdLegalRepresentative() == null ?
                    "Registrar Representante Legal" : "Editar Representante Legal");
            model.addAttribute("subtitle", legalRepresentative.getIdLegalRepresentative() == null ?
                    "Nuevo Representante Legal" : "Modificar Representante Legal");
            return "legal-representatives/create-legal-representative";
        }

        // Guarda o actualiza automáticamente
        legalRepresentativeService.saveLegalRepresentative(legalRepresentative);
        return "redirect:/legal-representative";
    }
}
