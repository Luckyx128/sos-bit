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

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UserController {
	

		@Autowired
		private UserService userService;
		
		@GetMapping
		public List<UserDTO> listarTodos(){
			return userService.listAll();
		}
		
		@GetMapping(value = "/{id}")
		public UserDTO buscarUsuarioPeloId(@PathVariable("id") String id) {
			return userService.buscarPorId(id);
		}

		@PostMapping(value = "/cadastrar")
		public void insert(@RequestBody UserDTO usuario) {
			userService.insert(usuario);
		}
		
		@PutMapping
		public UserDTO update(@RequestBody UserDTO usuario) {
			return userService.update(usuario);
		}
		
		//http://endereco/usuario/3
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> excluir(@PathVariable("id") String id){
			userService.excluir(id);
			return ResponseEntity.ok().build();
		}
	}

