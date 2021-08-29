package com.tuanmd.socialnetwork.modal.response;

import com.tuanmd.socialnetwork.entity.User;

public class AuthenticationResponse {
	private String token;

	private User user;

	public String getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}

	public AuthenticationResponse(String token, User user) {
		this.token = token;
		this.user = user;
	}

	public AuthenticationResponse() {
	}

}
