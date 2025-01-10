package com.teamlink.team_link.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_SECTION")
public class SectionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private PlanModel plan;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SectionExercise> exercises = new HashSet<>();

    // Getters and Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public PlanModel getPlan() {
        return plan;
    }
    public void setPlan(PlanModel plan) {
        this.plan = plan;
    }
    public Set<SectionExercise> getExercises() {
        return exercises;
    }
    public void setExercises(Set<SectionExercise> exercises) {
        this.exercises = exercises;
    }

    // Other methods
    public void addSectionExercise(SectionExercise sectionExercise) {
        exercises.add(sectionExercise);
    }
}