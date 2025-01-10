package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.SectionExerciseDTO;
import com.teamlink.team_link.models.SectionExercise;
import com.teamlink.team_link.repositories.SectionExerciseRepository;
import com.teamlink.team_link.services.SectionExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sectionexercise")
public class SectionExerciseController {
    private final SectionExerciseRepository sectionExerciseRepository;
    private final SectionExerciseService sectionExerciseService;

    public SectionExerciseController(SectionExerciseRepository sectionExerciseRepository, SectionExerciseService sectionExerciseService) {
        this.sectionExerciseRepository = sectionExerciseRepository;
        this.sectionExerciseService = sectionExerciseService;
    }

    @PostMapping
    public ResponseEntity<SectionExercise> saveSectionExercise(@RequestBody SectionExerciseDTO sectionExerciseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionExerciseService.saveSectionExercise(sectionExerciseDTO));
    }

    @GetMapping
    public ResponseEntity<List<SectionExercise>> getAllSectionExercises() {
        return ResponseEntity.ok(sectionExerciseRepository.findAll());
    }

}
