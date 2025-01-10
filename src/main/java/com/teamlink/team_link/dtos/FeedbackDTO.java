package com.teamlink.team_link.dtos;

import java.util.UUID;

public record FeedbackDTO(
        UUID userId,
        String description,
        UUID groupId,
        UUID practiceId
) {
}
