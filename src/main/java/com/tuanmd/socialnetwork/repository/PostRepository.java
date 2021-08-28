package com.tuanmd.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuanmd.socialnetwork.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	public List<Post> findByUserId(int id);

	public List<Post> findAllByOrderByIdDesc();
}
