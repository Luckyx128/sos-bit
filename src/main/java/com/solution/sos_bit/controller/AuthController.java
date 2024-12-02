package com.solution.sos_bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.sos_bit.handler.BusinessException;
import com.solution.sos_bit.dto.AuthenticationDTO;
import com.solution.sos_bit.service.AuthService;
import com.solution.sos_bit.service.RefreshToken;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	 @Operation(summary = "Realizar login", 
	         description = "Loga o usuario com login e senha e retornar o token para acesso")
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
		if(authDto.getUsername().isBlank() || authDto.getPassword().isBlank()) {
			throw new BusinessException("O login e senja são obrigatórios");
		}
		return ResponseEntity.ok(authService.login(authDto));
	}
	 
	 
	 @Operation(summary = "Recaregar token", 
	         description = "Retorna um novo token de login quando expirado")
	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshToken(@RequestBody RefreshToken refreshToken) {
	    if(authService.refreshToken(refreshToken.getToken()) != null)	{
		
	    	return ResponseEntity.ok(authService.refreshToken(refreshToken.getToken()));
	    } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token is invalid!");
	    }
	}
}

