package com.abyrc.thesimpsons.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abyrc.thesimpsons.services.FirstAppearanceEpService;

@RestController
@RequestMapping("/first-Appearance-ep")
public class FirstAppearanceEpController {

    private final FirstAppearanceEpService service;

    public FirstAppearanceEpController(FirstAppearanceEpService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAllActor() {
        return ResponseEntity.ok(service.getAllFirstAppearanceEps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdActor(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFirstAppearanceEpById(id));
    }
}
