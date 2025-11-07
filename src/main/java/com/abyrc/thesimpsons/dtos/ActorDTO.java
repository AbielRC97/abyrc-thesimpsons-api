package com.abyrc.thesimpsons.dtos;

import java.util.List;

public class ActorDTO {
    private String name;
    private Integer age;
    private String occupation;
    private List<String> phrases;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public List<String> getPhrases() {
        return phrases;
    }
    public void setPhrases(List<String> phrases) {
        this.phrases = phrases;
    }

    
}
