package com.tuanmd.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuanmd.socialnetwork.entity.Group;
import com.tuanmd.socialnetwork.repository.GroupRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class GroupController {
	@Autowired
	private GroupRepository groupRepository;

	@GetMapping("/groups")
	public List<Group> getGroups() {
		return groupRepository.findAll();
	}

	@PostMapping("/groups/import")
	public List<Group> importGroups(@RequestBody List<Group> groups) {
		return groupRepository.saveAll(groups);
	}
}
