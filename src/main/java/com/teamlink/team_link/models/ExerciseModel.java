package com.teamlink.team_link.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_EXERCISE")
public class ExerciseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SectionExercise> sectionExercises = new HashSet<>();

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public Set<SectionExercise> getSectionExercises() {
        return sectionExercises;
    }
    public void setSectionExercises(Set<SectionExercise> sectionExercises) {
        this.sectionExercises = sectionExercises;
    }

}
