package com.tuanmd.socialnetwork.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuanmd.socialnetwork.entity.User;
import com.tuanmd.socialnetwork.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return userRepository.findById(id);
	}

	@PostMapping("users/import")
	public List<User> importUsers(@RequestBody List<User> users) {
		return userRepository.saveAll(users);
	}

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}
}
