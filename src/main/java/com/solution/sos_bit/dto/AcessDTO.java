package com.solution.sos_bit.dto;

public class AcessDTO {
	private String token;
	private String refreshToken;	
	//TODO implementar retorna o usuario e liberacoes ( O que o token libera)
	public AcessDTO(String token,String refreshToken) {
		super();
		this.token = token;
		this.refreshToken = refreshToken;
	}
	
	public AcessDTO(String token) {
		super();
		this.token = token;
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
}
