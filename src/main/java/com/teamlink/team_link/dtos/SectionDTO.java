package com.teamlink.team_link.dtos;

import java.util.Set;
import java.util.UUID;

public record SectionDTO(
        String description,
        UUID planId,
        Set<UUID> sectionExerciseIds
) {
}
