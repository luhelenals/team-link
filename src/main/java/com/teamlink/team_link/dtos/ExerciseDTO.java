package com.teamlink.team_link.dtos;

import java.util.UUID;

public record ExerciseDTO(
        String title,
        String description,
        UUID userID
) {
}
