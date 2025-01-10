package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.SectionDTO;
import com.teamlink.team_link.models.SectionModel;
import com.teamlink.team_link.repositories.SectionRepository;
import com.teamlink.team_link.services.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("section")
public class SectionController {
    private final SectionRepository sectionRepository;
    private final SectionService sectionService;

    public SectionController(SectionRepository sectionRepository, SectionService sectionService) {
        this.sectionRepository = sectionRepository;
        this.sectionService = sectionService;
    }

    @PostMapping
    public ResponseEntity<SectionModel> saveSection(@RequestBody SectionDTO sectionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.saveSection(sectionDTO));
    }

    @GetMapping
    public ResponseEntity<List<SectionModel>> getAllSections() {
        return ResponseEntity.ok(sectionRepository.findAll());
    }
}
