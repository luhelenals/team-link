package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.PracticeDTO;
import com.teamlink.team_link.models.PracticeModel;
import com.teamlink.team_link.repositories.PracticeRepository;
import com.teamlink.team_link.services.PracticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/practice")
public class PracticeController {
    private final PracticeService practiceService;
    private final PracticeRepository practiceRepository;

    public PracticeController(PracticeService practiceService, PracticeRepository practiceRepository) {
        this.practiceService = practiceService;
        this.practiceRepository = practiceRepository;
    }

    @PostMapping
    public ResponseEntity<PracticeModel> savePractice(PracticeDTO practiceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(practiceService.savePractice(practiceDTO));
    }

    @GetMapping
    public ResponseEntity<List<PracticeModel>> getPractices() {
        return ResponseEntity.ok(practiceRepository.findAll());
    }
}
