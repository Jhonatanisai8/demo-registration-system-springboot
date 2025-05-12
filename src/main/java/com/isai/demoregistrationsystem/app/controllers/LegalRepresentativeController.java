package com.isai.demoregistrationsystem.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/legal-representative")
public class LegalRepresentativeController {

    @GetMapping(path = "/create-legal-representative")
    public String viewCreateStudent() {
        return "legal-representatives/create-legal-representative";
    }
}
