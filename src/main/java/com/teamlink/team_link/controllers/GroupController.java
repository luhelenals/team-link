package com.teamlink.team_link.controllers;

import com.teamlink.team_link.dtos.GroupDTO;
import com.teamlink.team_link.models.GroupModel;
import com.teamlink.team_link.repositories.GroupRepository;
import com.teamlink.team_link.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    private final GroupRepository groupRepository;

    public GroupController(GroupService groupService, GroupRepository groupRepository) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
    }

    @PostMapping
    public ResponseEntity<GroupModel> saveGroup(@RequestBody GroupDTO groupDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.saveGroup(groupDTO));
    }

    @GetMapping
    public ResponseEntity<List<GroupModel>> getAllGroups() {
        return ResponseEntity.ok(groupRepository.findAll());
    }
}
