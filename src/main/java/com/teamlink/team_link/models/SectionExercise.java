package com.teamlink.team_link.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_SECTION_EXERCISE")
public class SectionExercise implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private SectionModel section;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseModel exercise;

    @Column(nullable = false)
    private int duration; // Duration in seconds or any preferred unit

    // Getters and Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public SectionModel getSection() {
        return section;
    }
    public void setSection(SectionModel section) {
        this.section = section;
    }
    public ExerciseModel getExercise() {
        return exercise;
    }
    public void setExercise(ExerciseModel exercise) {
        this.exercise = exercise;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
