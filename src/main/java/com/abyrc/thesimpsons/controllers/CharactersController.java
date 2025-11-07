package com.abyrc.thesimpsons.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abyrc.thesimpsons.entities.Actor;
import com.abyrc.thesimpsons.services.SimpsonApiService;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/characters")
public class CharactersController {
    private final SimpsonApiService simpsonApiService;

    public CharactersController(SimpsonApiService simpsonApiService) {
        this.simpsonApiService = simpsonApiService;
    }

    @GetMapping("/{id}")
    public Mono<Actor> getMethodName(@PathVariable Long id) {
        return simpsonApiService.getActors(id);
    }
    
}
