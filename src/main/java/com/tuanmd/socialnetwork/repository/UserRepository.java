package com.tuanmd.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuanmd.socialnetwork.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}
