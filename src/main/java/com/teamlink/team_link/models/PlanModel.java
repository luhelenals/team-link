package com.teamlink.team_link.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PLAN")
public class PlanModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany
    @JoinColumn(name = "practice_id")
    private Set<PracticeModel> practices = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "section_id")
    private Set<SectionModel> sections = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel creator;

    // Other methods
    public void addSection(SectionModel section) {
        sections.add(section);
    }
    public void addPractice(PracticeModel practice) {
        practices.add(practice);
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }
    public Set<PracticeModel> getPractices() {
        return practices;
    }
    public void setPractice(Set<PracticeModel> practices) {
        this.practices = practices;
    }
    public Set<SectionModel> getSections() {
        return sections;
    }
    public void setSections(Set<SectionModel> sections) {
        this.sections = sections;
    }
    public UserModel getcreator() {
        return creator;
    }
    public void setcreator(UserModel user) {
        this.creator = user;
    }
}
