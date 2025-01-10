package com.teamlink.team_link.services;

import com.teamlink.team_link.dtos.FeedbackDTO;
import com.teamlink.team_link.models.FeedbackModel;
import com.teamlink.team_link.repositories.FeedbackRepository;
import com.teamlink.team_link.repositories.GroupRepository;
import com.teamlink.team_link.repositories.PracticeRepository;
import com.teamlink.team_link.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final PracticeRepository practiceRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, UserRepository userRepository, GroupRepository groupRepository, PracticeRepository practiceRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.practiceRepository = practiceRepository;
    }

    @Transactional
    public FeedbackModel saveFeedback(FeedbackDTO feedbackDTO) {
        FeedbackModel feedback = new FeedbackModel();

        feedback.setDescription(feedbackDTO.description());
        feedback.setGroup(groupRepository.findById(feedbackDTO.groupId()).orElse(null));
        feedback.setPractice(practiceRepository.findById(feedbackDTO.practiceId()).orElse(null));
        feedback.setUser(userRepository.findById(feedbackDTO.userId()).orElse(null));

        return feedbackRepository.save(feedback);
    }
}
