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

    @GetMapping(path = "/create")
    public String viewLegalRepresentative(Map<String, Object> model) {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        model.put("legalRepresentative", legalRepresentative);
        return "legal-representatives/create-legal-representative";
    }

    @PostMapping(path = "/create")
    public String saveLegalRepresentative(
            @Valid LegalRepresentative legalRepresentative,
            BindingResult bindingResult,
            Model model) {
        model.addAttribute("title", "Registro de Representantes Legales");
        model.addAttribute("subtitle", "Registro de Representantes Legal");
        if (bindingResult.hasErrors()) {
            return "legal-representatives/create-legal-representative";
        }
        legalRepresentativeService.saveLegalRepresentative(legalRepresentative);
        return "redirect:/legal-representative";
    }


}
