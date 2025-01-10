package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.SectionModel;
import com.teamlink.team_link.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectionRepository extends JpaRepository<SectionModel, UUID> {
}
