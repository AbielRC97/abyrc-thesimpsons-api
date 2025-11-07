package com.abyrc.thesimpsons.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abyrc.thesimpsons.automappers.ActorMapper;
import com.abyrc.thesimpsons.dtos.ActorDTO;
import com.abyrc.thesimpsons.dtos.FirstAppearanceEpDTO;
import com.abyrc.thesimpsons.entities.FirstAppearanceEp;
import com.abyrc.thesimpsons.repositories.ActorRepository;
import com.abyrc.thesimpsons.repositories.FirstAppearanceEpRepository;

@Service
public class FirstAppearanceEpService {
    private final FirstAppearanceEpRepository repository;
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public FirstAppearanceEpService(FirstAppearanceEpRepository repository, ActorRepository actorRepository, ActorMapper actorMapper) {
        this.repository = repository;
        this.actorRepository = actorRepository;
        this.actorMapper = actorMapper;
    }

    public List<FirstAppearanceEp> getAllFirstAppearanceEps() {
        return repository.findAll();
    }

    public Optional<FirstAppearanceEpDTO> getFirstAppearanceEpById(Long id) {
        var firstAppearanceEp = repository.findById(id);
        if(!firstAppearanceEp.isPresent()) {
            return Optional.empty();
        }
        FirstAppearanceEp firstAppearanceEpEntity = firstAppearanceEp.get();
        List<ActorDTO> filters = actorRepository.findAllByFirstAppearanceEp_Id(id).stream().map(actorMapper::toDTO).toList();
        FirstAppearanceEpDTO nuevo = new FirstAppearanceEpDTO();
        nuevo.setSynopsis(firstAppearanceEpEntity.getSynopsis());
        nuevo.setActors(filters);
        return Optional.of(nuevo);
    }
}
