package com.teamlink.team_link.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true) // Email should be unique
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "USER_GROUP", // Join table name
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<GroupModel> groups = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "USER_PRACTICE", // Join table name
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "practice_id")
    )
    private Set<PracticeModel> practices = new HashSet<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlanModel> plans = new HashSet<>();

    // Other methods
    public void addPractice(PracticeModel practice) {
        practices.add(practice);
    }
    public void addFeedback(FeedbackModel feedback) {
        feedbacks.add(feedback);
    }
    public void addPlan(PlanModel plan) {
        plans.add(plan);
    }
    public void addGroup(GroupModel group) {
        groups.add(group);
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Set<GroupModel> getGroups() {
        return groups;
    }
    public void setGroups(Set<GroupModel> groups) {
        this.groups = groups;
    }
    public Set<FeedbackModel> getFeedbacks() {
        return feedbacks;
    }
    public void setFeedbacks(Set<FeedbackModel> feedbacks) {
        this.feedbacks = feedbacks;
    }
    public Set<PracticeModel> getPractices() {
        return practices;
    }
    public void setPractices(Set<PracticeModel> practices) {
        this.practices = practices;
    }
    public Set<PlanModel> getPlans() {
        return plans;
    }
    public void setPlans(Set<PlanModel> plans) {
        this.plans = plans;
    }
}
