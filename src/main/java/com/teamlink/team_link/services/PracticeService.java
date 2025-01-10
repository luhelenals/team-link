package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.PracticeDTO;
import com.teamlink.team_link.models.GroupModel;
import com.teamlink.team_link.models.PracticeModel;
import com.teamlink.team_link.models.UserModel;
import com.teamlink.team_link.repositories.GroupRepository;
import com.teamlink.team_link.repositories.PlanRepository;
import com.teamlink.team_link.repositories.PracticeRepository;
import com.teamlink.team_link.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PracticeService {
    private final PracticeRepository practiceRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;
    private final GroupRepository groupRepository;

    public PracticeService(PracticeRepository practiceRepository, UserRepository userRepository,
                           PlanRepository planRepository, GroupRepository groupRepository) {
        this.practiceRepository = practiceRepository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
        this.groupRepository = groupRepository;
    }

    public PracticeModel savePractice(PracticeDTO practiceDTO) {
        PracticeModel practice = new PracticeModel();

        Set<GroupModel> groups = StreamSupport.stream(
                groupRepository.findAllById(practiceDTO.groupIds()).spliterator(), false
        ).collect(Collectors.toSet());

        Set<UserModel> attendees = StreamSupport.stream(
                userRepository.findAllById(practiceDTO.attendeesIds()).spliterator(), false
        ).collect(Collectors.toSet());

        practice.setDescription(practiceDTO.description());
        practice.setTime(practiceDTO.time());
        practice.setPlace(practiceDTO.place());
        practice.setPlan(planRepository.findById(practiceDTO.planId()).orElse(null));
        practice.setGroups(groups);
        practice.setAttendees(attendees);

        return practiceRepository.save(practice);
    }
}
