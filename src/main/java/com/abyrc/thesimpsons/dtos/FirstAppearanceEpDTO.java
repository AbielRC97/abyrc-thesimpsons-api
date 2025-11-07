package com.abyrc.thesimpsons.dtos;

import java.util.List;

public class FirstAppearanceEpDTO {
    private String synopsis;
    private List<ActorDTO> actors;
    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public List<ActorDTO> getActors() {
        return actors;
    }
    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }

    
}
