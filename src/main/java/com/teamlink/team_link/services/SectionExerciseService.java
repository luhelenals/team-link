package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.SectionExerciseDTO;
import com.teamlink.team_link.models.SectionExercise;
import com.teamlink.team_link.repositories.ExerciseRepository;
import com.teamlink.team_link.repositories.SectionExerciseRepository;
import com.teamlink.team_link.repositories.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionExerciseService {
    private final SectionRepository sectionRepository;
    private final SectionExerciseRepository sectionExerciseRepository;
    private final ExerciseRepository exerciseRepository;

    public SectionExerciseService(SectionRepository sectionRepository, SectionExerciseRepository sectionExerciseRepository, ExerciseRepository exerciseRepository) {
        this.sectionRepository = sectionRepository;
        this.sectionExerciseRepository = sectionExerciseRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public SectionExercise saveSectionExercise(SectionExerciseDTO sectionExerciseDTO) {
        SectionExercise sectionExercise = new SectionExercise();

        sectionExercise.setExercise(exerciseRepository.findById(sectionExerciseDTO.exerciseId()).orElse(null));
        sectionExercise.setDuration(sectionExerciseDTO.duration());
        sectionExercise.setSection(sectionRepository.findById(sectionExerciseDTO.sectionId()).orElse(null));

        return sectionExerciseRepository.save(sectionExercise);
    }
}
