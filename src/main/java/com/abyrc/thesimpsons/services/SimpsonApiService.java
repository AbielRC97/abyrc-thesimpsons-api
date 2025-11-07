package com.abyrc.thesimpsons.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.abyrc.thesimpsons.entities.Actor;

import reactor.core.publisher.*;

@Service
public class SimpsonApiService {
    private final WebClient webClient;

    public SimpsonApiService(@Value("${external.api.base-url}") String baseUrl,
            WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }


    public Mono<Actor> getActors(Long id) {
        return webClient.get()
                .uri("/api/characters/{id}", id)
                .retrieve()
                .bodyToMono(Actor.class);
    }
}
