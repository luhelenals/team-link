package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.ExerciseDTO;
import com.teamlink.team_link.models.ExerciseModel;
import com.teamlink.team_link.repositories.ExerciseRepository;
import com.teamlink.team_link.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, UserRepository userRepository) {
        this.exerciseRepository = exerciseRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ExerciseModel saveExercise(ExerciseDTO exerciseDTO) {
        ExerciseModel exercise = new ExerciseModel();
        exercise.setDescription(exerciseDTO.description());
        exercise.setTitle(exerciseDTO.title());
        exercise.setCreator(userRepository.findById(exerciseDTO.userID()).orElse(null));

        return exerciseRepository.save(exercise);
    }
}
