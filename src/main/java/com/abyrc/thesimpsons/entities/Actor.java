package com.abyrc.thesimpsons.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    private Long id;
    private Integer age;
    private String birthdate;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "first_appearance_ep_id", insertable = false, updatable = false)
    private Integer first_appearance_ep_id;
    private Integer first_appearance_sh_id;
    private String gender;
    private String name;
    private String occupation;
    private List<String> phrases;
    private String portrait_path;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "first_appearance_ep_id")
    private FirstAppearanceEp first_appearance_ep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFirst_appearance_ep_id() {
        return first_appearance_ep_id;
    }

    public void setFirst_appearance_ep_id(Integer first_appearance_ep_id) {
        this.first_appearance_ep_id = first_appearance_ep_id;
    }

    public Integer getFirst_appearance_sh_id() {
        return first_appearance_sh_id;
    }

    public void setFirst_appearance_sh_id(Integer first_appearance_sh_id) {
        this.first_appearance_sh_id = first_appearance_sh_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPortrait_path() {
        return portrait_path;
    }

    public void setPortrait_path(String portrait_path) {
        this.portrait_path = portrait_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FirstAppearanceEp getFirst_appearance_ep() {
        return first_appearance_ep;
    }

    public void setFirst_appearance_ep(FirstAppearanceEp first_appearance_ep) {
        this.first_appearance_ep = first_appearance_ep;
    }
}