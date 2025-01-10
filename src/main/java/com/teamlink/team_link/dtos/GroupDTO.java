package com.teamlink.team_link.dtos;

import java.util.Set;
import java.util.UUID;

public record GroupDTO(
        String description,
        Set<UUID> coaches,
        Set<UUID> athletes
) {
}
