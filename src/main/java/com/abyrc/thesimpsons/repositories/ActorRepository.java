package com.abyrc.thesimpsons.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abyrc.thesimpsons.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    boolean existsById(Long id);

    List<Actor> findAllByFirstAppearanceEp_Id(Long id);
}