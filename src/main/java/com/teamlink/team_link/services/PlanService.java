package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.PlanDTO;
import com.teamlink.team_link.models.PlanModel;
import com.teamlink.team_link.models.PracticeModel;
import com.teamlink.team_link.models.SectionModel;
import com.teamlink.team_link.models.UserModel;
import com.teamlink.team_link.repositories.PlanRepository;
import com.teamlink.team_link.repositories.PracticeRepository;
import com.teamlink.team_link.repositories.SectionRepository;
import com.teamlink.team_link.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlanService {
    private final PlanRepository planRepository;
    private final UserRepository userRepository;
    private final SectionRepository sectionRepository;
    private final PracticeRepository practiceRepository;

    public PlanService(PlanRepository planRepository, UserRepository userRepository, SectionRepository sectionRepository, PracticeRepository practiceRepository) {
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.sectionRepository = sectionRepository;
        this.practiceRepository = practiceRepository;
    }

    public PlanModel savePlan(PlanDTO planDTO) {
        PlanModel plan = new PlanModel();

        Set<PracticeModel> practices = StreamSupport.stream(
                practiceRepository.findAllById(planDTO.practiceIds()).spliterator(), false
        ).collect(Collectors.toSet());

        Set<SectionModel> sections = StreamSupport.stream(
                sectionRepository.findAllById(planDTO.sectionIds()).spliterator(), false
        ).collect(Collectors.toSet());

        plan.setPractice(practices);
        plan.setSections(sections);
        plan.setcreator(userRepository.findById(planDTO.userId()).orElse(null));

        return planRepository.save(plan);
    }
}
