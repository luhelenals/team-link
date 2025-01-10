package com.teamlink.team_link.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_FEEDBACK")
public class FeedbackModel implements Serializable { // Renamed to FeedbackModel
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Ensure this is non-null if every feedback must have a user
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "practice_id", nullable = true) // Nullable if feedback may not be linked to a practice
    private PracticeModel practice;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true) // Nullable if feedback may not be linked to a group
    private GroupModel group;

    // Getters and Setters
    public UUID getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public PracticeModel getPractice() {
        return practice;
    }
    public void setPractice(PracticeModel practice) {
        this.practice = practice;
    }
    public GroupModel getGroup() {
        return group;
    }
    public void setGroup(GroupModel group) {
        this.group = group;
    }
}
