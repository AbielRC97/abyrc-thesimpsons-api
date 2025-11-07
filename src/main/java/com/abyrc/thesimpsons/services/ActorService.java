package com.abyrc.thesimpsons.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abyrc.thesimpsons.automappers.ActorMapper;
import com.abyrc.thesimpsons.dtos.ActorDTO;
import com.abyrc.thesimpsons.entities.Actor;
import com.abyrc.thesimpsons.repositories.ActorRepository;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ActorService {
    private final SimpsonApiService simpsonApiService;
    private final ActorRepository actorRepository;
    private final ActorMapper mapper;

    public ActorService(SimpsonApiService simpsonApiService, ActorRepository actorRepository, ActorMapper mapper) {
        this.simpsonApiService = simpsonApiService;
        this.actorRepository = actorRepository;
        this.mapper = mapper;
    }

    public boolean existsActorById(Long id) {
        return actorRepository.existsById(id);
    }


    public Mono<ActorDTO> getActorById(Long id) {
        return Mono.fromCallable(() -> simpsonApiService.getActors(id)).subscribeOn(Schedulers.boundedElastic()).map(item -> {
            Actor select = item.block();
            if (select == null) {
                throw new IllegalArgumentException("Actor not found");
            }
            actorRepository.save(select);
            return mapper.toDTO(select);
        });
    }

    public List<ActorDTO> getAllActors() {
        return actorRepository.findAll().stream().map(mapper::toDTO).toList();
    }

}
