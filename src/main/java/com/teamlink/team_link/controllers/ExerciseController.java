package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.ExerciseDTO;
import com.teamlink.team_link.models.ExerciseModel;
import com.teamlink.team_link.repositories.ExerciseRepository;
import com.teamlink.team_link.services.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseService exerciseService, ExerciseRepository exerciseRepository) {
        this.exerciseService = exerciseService;
        this.exerciseRepository = exerciseRepository;
    }

    @PostMapping
    public ResponseEntity<ExerciseModel> saveExercise(@RequestBody ExerciseDTO exerciseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.saveExercise(exerciseDTO));
    }

    @GetMapping
    public ResponseEntity<List<ExerciseModel>> getAllExercises() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }
}
