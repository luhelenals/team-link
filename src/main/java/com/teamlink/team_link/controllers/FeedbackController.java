package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.FeedbackDTO;
import com.teamlink.team_link.models.FeedbackModel;
import com.teamlink.team_link.repositories.FeedbackRepository;
import com.teamlink.team_link.services.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackService feedbackService, FeedbackRepository feedbackRepository) {
        this.feedbackService = feedbackService;
        this.feedbackRepository = feedbackRepository;
    }

    @PostMapping
    public ResponseEntity<FeedbackModel> saveFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.saveFeedback(feedbackDTO));
    }

    @GetMapping
    public ResponseEntity<List<FeedbackModel>> getFeedbacks() {
        return ResponseEntity.status(HttpStatus.OK).body(feedbackRepository.findAll());
    }
}
