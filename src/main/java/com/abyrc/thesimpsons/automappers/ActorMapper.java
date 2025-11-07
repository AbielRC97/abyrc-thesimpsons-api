package com.abyrc.thesimpsons.automappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.abyrc.thesimpsons.dtos.ActorDTO;
import com.abyrc.thesimpsons.entities.Actor;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    // Mapea un solo usuario a DTO
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "occupation", source = "occupation")
    @Mapping(target = "phrases", source = "phrases")
    ActorDTO toDTO(Actor user);

    @Mapping(target = "name", ignore = true) 
    Actor toEntity(Actor actor);
}
