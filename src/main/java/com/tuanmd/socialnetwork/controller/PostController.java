package com.tuanmd.socialnetwork.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuanmd.socialnetwork.entity.Post;
import com.tuanmd.socialnetwork.repository.PostRepository;
import com.tuanmd.socialnetwork.service.PostService;

@RestController
@CrossOrigin("http://localhost:3000")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostService postService;

	Logger logger = LoggerFactory.getLogger(PostController.class);

	@GetMapping("/posts")
	public Page<Post> getPosts(@RequestParam(required = false, defaultValue = "0") int pageIndex,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		return postService.getPosts(pageIndex, pageSize);
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> getPostsByUserId(@PathVariable int id) {
		return postRepository.findByUserId(id);
	}

	@PostMapping("users/{userId}/posts")
	public Post createPost(@PathVariable int userId, @RequestBody Post post) {
		return postService.createPost(userId, post);
	}

	@PutMapping("/posts/{id}")
	public Post updatePost(@PathVariable int id, @RequestBody Post post) {
		post.setId(id);
		return postService.updatePost(id, post.getContent());
	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable int id) {
		postRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/posts/import")
	public List<Post> importPosts(@RequestBody List<Post> posts) {
		return postRepository.saveAll(posts);
	}
}
