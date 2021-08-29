package com.tuanmd.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuanmd.socialnetwork.entity.User;
import com.tuanmd.socialnetwork.modal.request.AuthenticationRequest;
import com.tuanmd.socialnetwork.modal.response.AuthenticationResponse;
import com.tuanmd.socialnetwork.repository.UserRepository;
import com.tuanmd.socialnetwork.service.CustomUserDetailService;
import com.tuanmd.socialnetwork.util.JwtUtil;

@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService userDetailService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		String email = authenticationRequest.getEmail();

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(email, authenticationRequest.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		UserDetails userDetails = userDetailService.loadUserByUsername(email);
		String token = jwtUtil.generateToken(userDetails);
		User user = userRepository.findByEmail(email);

		return ResponseEntity.ok(new AuthenticationResponse(token, user));
	}
}
