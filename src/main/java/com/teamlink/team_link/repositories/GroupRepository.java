package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<GroupModel, UUID> {
}
