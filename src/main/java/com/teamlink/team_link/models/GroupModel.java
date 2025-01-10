package com.teamlink.team_link.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_GROUP")
public class GroupModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "GROUP_COACHES", // Join table name
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    private Set<UserModel> coaches = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "GROUP_ATHLETES", // Join table name
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private Set<UserModel> athletes = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "feedback_id")
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "GROUP_PRACTICE",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "practice_id")
    )
    private Set<PracticeModel> practices = new HashSet<>();

    // Other methods
    public void addAthlete(UserModel user) {
        athletes.add(user);
    }
    public void addCoach(UserModel user) {
        coaches.add(user);
    }
    public void addFeedback(FeedbackModel feedback) {
        feedbacks.add(feedback);
    }
    public void addPractice(PracticeModel practice) {
        practices.add(practice);
    }

    // Getters and Setters
    public void setFeedbacks(Set<FeedbackModel> feedbacks) {
        this.feedbacks = feedbacks;
    }
    public void setPractices(Set<PracticeModel> practices) {
        this.practices = practices;
    }
    public Set<FeedbackModel> getFeedbacks() {
        return feedbacks;
    }
    public Set<PracticeModel> getPractices() {
        return practices;
    }
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
    public Set<UserModel> getCoaches() {
        return coaches;
    }
    public void setCoaches(Set<UserModel> coaches) {
        this.coaches = coaches;
    }
    public Set<UserModel> getAthletes() {
        return athletes;
    }
    public void setAthletes(Set<UserModel> athletes) {
        this.athletes = athletes;
    }
}
