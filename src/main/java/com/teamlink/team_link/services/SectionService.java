package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.SectionDTO;
import com.teamlink.team_link.models.SectionExercise;
import com.teamlink.team_link.models.SectionModel;
import com.teamlink.team_link.models.UserModel;
import com.teamlink.team_link.repositories.PlanRepository;
import com.teamlink.team_link.repositories.SectionExerciseRepository;
import com.teamlink.team_link.repositories.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SectionExerciseRepository sectionExerciseRepository;
    private final PlanRepository planRepository;

    public SectionService(SectionRepository sectionRepository, SectionExerciseRepository sectionExerciseRepository, PlanRepository planRepository) {
        this.sectionRepository = sectionRepository;
        this.sectionExerciseRepository = sectionExerciseRepository;
        this.planRepository = planRepository;
    }

    public SectionModel saveSection(SectionDTO sectionDTO) {
        SectionModel section = new SectionModel();

        Set<SectionExercise> exercises = StreamSupport.stream(
                sectionExerciseRepository.findAllById(sectionDTO.sectionExerciseIds()).spliterator(), false
        ).collect(Collectors.toSet());

        section.setDescription(sectionDTO.description());
        section.setPlan(planRepository.findById(sectionDTO.planId()).orElse(null));
        section.setExercises(exercises);

        return sectionRepository.save(section);
    }
}
