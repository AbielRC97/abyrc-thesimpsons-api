package com.abyrc.thesimpsons.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abyrc.thesimpsons.entities.Actor;
import com.abyrc.thesimpsons.repositories.ActorRepository;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ActorService {
    private final SimpsonApiService simpsonApiService;
    private final ActorRepository actorRepository;

    public ActorService(SimpsonApiService simpsonApiService, ActorRepository actorRepository) {
        this.simpsonApiService = simpsonApiService;
        this.actorRepository = actorRepository;
    }

    public boolean existsActorById(Long id) {
        return actorRepository.existsById(id);
    }

    public Mono<Actor> getActorById(Long id) {
        return Mono.fromCallable(() -> {
            // Verifica si existe en la base de datos (bloqueante)
            return actorRepository.findById(id)
                    .orElseGet(() -> {
                        // Si no existe, llama a la API externa (reactivo, pero usamos block aquí)
                        Actor actor = simpsonApiService.getActors(id).block();
                        return actorRepository.save(actor);
                    });
        }).subscribeOn(Schedulers.boundedElastic()); // ← mueve la carga bloqueante a otro hilo
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

}
