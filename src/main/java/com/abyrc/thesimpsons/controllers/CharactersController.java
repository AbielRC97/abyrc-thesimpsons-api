package com.abyrc.thesimpsons.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abyrc.thesimpsons.services.ActorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/characters")
public class CharactersController {
    private final ActorService service;

    public CharactersController(ActorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findActorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getActorById(id));
    }
    
    @GetMapping
    public ResponseEntity<?> findAllActor() {
        return ResponseEntity.ok(service.getAllActors());
    }
}
