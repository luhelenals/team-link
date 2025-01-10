package com.teamlink.team_link.dtos;

import java.util.Set;
import java.util.UUID;

public record PlanDTO(
        Set<UUID> sectionIds,
        Set<UUID> practiceIds,
        UUID userId
) {
}
