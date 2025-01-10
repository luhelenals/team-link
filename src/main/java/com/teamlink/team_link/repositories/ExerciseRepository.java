package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.ExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<ExerciseModel, UUID> {
}
