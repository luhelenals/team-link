package com.teamlink.team_link.dtos;

import java.util.Set;
import java.util.UUID;

public record GroupDTO(
        String description,
        Set<UUID> coachIds,
        Set<UUID> athleteIds
) {
}
