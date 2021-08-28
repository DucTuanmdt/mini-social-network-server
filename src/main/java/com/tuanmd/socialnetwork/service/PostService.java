package com.tuanmd.socialnetwork.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tuanmd.socialnetwork.entity.Post;
import com.tuanmd.socialnetwork.entity.User;
import com.tuanmd.socialnetwork.repository.PostRepository;
import com.tuanmd.socialnetwork.repository.UserRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	public Post updatePost(int id, String content) {
		Optional<Post> currentPost = postRepository.findById(id);

		if (currentPost.isPresent()) {
			Post post = currentPost.get();
			post.setContent(content);
			return postRepository.save(post);
		}

		return null;
	}

	public Post createPost(int userId, Post post) {
		Optional<User> currentUser = userRepository.findById(userId);

		if (currentUser.isPresent()) {
			User user = currentUser.get();
			post.setUser(user);
			return postRepository.save(post);
		}

		return null;
	}

	public Page<Post> getPosts(int pageIndex, int pageSize) {
		Pageable firstPageWithTwoElements = PageRequest.of(pageIndex, pageSize, Sort.by("id").descending());
		return postRepository.findAll(firstPageWithTwoElements);
	}

}
