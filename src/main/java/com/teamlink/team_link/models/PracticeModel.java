package com.teamlink.team_link.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PRACTICE")
public class PracticeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private String place;

    @ManyToMany
    @JoinTable(
            name = "GROUP_PRACTICE", // Join table name
            joinColumns = @JoinColumn(name = "practice_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<GroupModel> groups = new HashSet<>();

    @ManyToMany(mappedBy = "practices")
    private Set<UserModel> attendees = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanModel plan;

    @OneToMany
    @JoinColumn(name = "feedback_id")
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    // Other methods
    public void addFeedback(FeedbackModel feedback) {
        feedbacks.add(feedback);
    }

    // Getters and Setters
    public void setFeedbacks(Set<FeedbackModel> feedbacks) {
        this.feedbacks = feedbacks;
    }
    public Set<FeedbackModel> getFeedbacks() {
        return feedbacks;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getPlace() {
        return place;
    }
    public void setGroups(Set<GroupModel> groups) {
        this.groups = groups;
    }
    public Set<GroupModel> getGroups() {
        return groups;
    }
    public void setAttendees(Set<UserModel> attendees) {
        this.attendees = attendees;
    }
    public Set<UserModel> getAttendees() {
        return attendees;
    }
    public void setPlan(PlanModel plan) {
        this.plan = plan;
    }
    public PlanModel getPlan() {
        return plan;
    }
    public UUID getId() {
        return id;
    }
}
