package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.PlanDTO;
import com.teamlink.team_link.models.PlanModel;
import com.teamlink.team_link.repositories.PlanRepository;
import com.teamlink.team_link.services.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    private final PlanService planService;
    private final PlanRepository planRepository;

    public PlanController(PlanService planService, PlanRepository planRepository) {
        this.planService = planService;
        this.planRepository = planRepository;
    }

    @PostMapping
    public ResponseEntity<PlanModel> savePlan(@RequestBody PlanDTO planDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.savePlan(planDTO));
    }

    @GetMapping
    public ResponseEntity<List<PlanModel>> getPlans() {
        return ResponseEntity.ok(planRepository.findAll());
    }
}
