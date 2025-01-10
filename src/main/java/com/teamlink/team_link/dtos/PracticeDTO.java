package com.teamlink.team_link.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record PracticeDTO(
        String description,
        LocalDateTime time,
        String place,
        Set<UUID> groupIds,
        UUID planId,
        Set<UUID> attendeesIds
) {
}
