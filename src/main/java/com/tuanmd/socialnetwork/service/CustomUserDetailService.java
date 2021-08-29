package com.tuanmd.socialnetwork.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuanmd.socialnetwork.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		com.tuanmd.socialnetwork.entity.User foundUser = userRepository.findByEmail(email);
		if (foundUser != null) {
			return new User(foundUser.getEmail(), foundUser.getPassword(), new ArrayList<>());
		}

		return null;
	}
}
