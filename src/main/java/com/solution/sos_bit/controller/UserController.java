package com.solution.sos_bit.controller;

import com.solution.sos_bit.dto.UserDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.sos_bit.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
@Tag(name = "UserController", description = "Gerenciamento e manuzeio de usuarios!")
public class UserController {
	

		@Autowired
		private UserService userService;
		
		@GetMapping
		 @Operation(summary = "Buscar todos os usuarios", 
         description = "Retora informações de todos os usuarios cadastrados no banco")
		public List<UserDTO> listarTodos(){
			return userService.listAll();
		}
		
		 @Operation(summary = "Buscar usuario pelo username", 
		         description = "Retora de um unico usuario pelo username")
		@GetMapping(value = "/{username}")
		public UserDTO buscarUsuarioPeloId(@PathVariable String username) {
			return userService.buscarPorId(username);
		}
		 
		 @Operation(summary = "Cadastrar usuario", 
		         description = "Cadastro de usuario")
		@PostMapping()
		public void insert(@RequestBody UserDTO usuario) {
			userService.insert(usuario);
		}
		 
		 @Operation(summary = "Atualizar usuario", 
		         description = "Principal utilidade atualizar senha de usuario")
		@PutMapping
		public UserDTO update(@RequestBody UserDTO usuario) {
			return userService.update(usuario);
		}
		
		 @Operation(summary = "Deletar usuario com o username", 
		         description = "Deleta o usuario buscando pelo username enviado")
		@DeleteMapping(value = "/{username}")
		public ResponseEntity<Void> excluir(@PathVariable String username){
			userService.excluir(username);
			return ResponseEntity.ok().build();
		}
	}

