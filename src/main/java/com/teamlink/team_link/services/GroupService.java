package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.GroupDTO;
import com.teamlink.team_link.models.GroupModel;
import com.teamlink.team_link.models.UserModel;
import com.teamlink.team_link.repositories.GroupRepository;
import com.teamlink.team_link.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GroupService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public GroupService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Transactional
    public GroupModel saveGroup(GroupDTO groupDTO) {
        GroupModel group = new GroupModel();

        group.setDescription(groupDTO.description());

        // Convert the Iterable result to a Set
        Set<UserModel> coaches = StreamSupport.stream(
                userRepository.findAllById(groupDTO.coachIds()).spliterator(), false
        ).collect(Collectors.toSet());
        group.setCoaches(coaches);

        Set<UserModel> athletes = StreamSupport.stream(
                userRepository.findAllById(groupDTO.athleteIds()).spliterator(), false
        ).collect(Collectors.toSet());
        group.setAthletes(athletes);

        return groupRepository.save(group);
    }
}