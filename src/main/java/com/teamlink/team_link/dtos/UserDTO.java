package com.teamlink.team_link.dtos;

import com.teamlink.team_link.models.Role;

public record UserDTO(
        String name,
        String email,
        String password,
        String phone,
        Role role
) {
}
