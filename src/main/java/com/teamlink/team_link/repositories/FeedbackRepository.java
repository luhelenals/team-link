package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, UUID> {
}
