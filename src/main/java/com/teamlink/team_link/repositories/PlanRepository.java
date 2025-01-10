package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanRepository extends JpaRepository<PlanModel, UUID> {
}
