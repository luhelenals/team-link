package com.teamlink.team_link.dtos;

import java.util.UUID;

public record SectionExerciseDTO(
        int duration,
        UUID exerciseId
) {
}
