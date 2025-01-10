package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.SectionExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectionExerciseRepository extends JpaRepository<SectionExercise, UUID> {
}
