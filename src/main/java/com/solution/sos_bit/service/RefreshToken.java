package com.solution.sos_bit.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshToken {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
