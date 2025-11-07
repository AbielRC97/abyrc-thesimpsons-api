package com.abyrc.thesimpsons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abyrc.thesimpsons.entities.FirstAppearanceEp;

@Repository
public interface FirstAppearanceEpRepository extends JpaRepository<FirstAppearanceEp, Long> {

}
