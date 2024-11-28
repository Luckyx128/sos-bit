package com.solution.sos_bit.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.solution.sos_bit.dto.UserDTO;
import com.solution.sos_bit.entity.RoleEntity;
import com.solution.sos_bit.entity.UserEntity;
import com.solution.sos_bit.repository.RoleRepository;
import com.solution.sos_bit.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


    public List<UserDTO> listAll(){
		List<UserEntity> usuarios = userRepository.findAll();
		return usuarios.stream().map(UserDTO::new).toList();
	}
	
	public void insert(UserDTO usuario) {

		Optional<RoleEntity> roleEntity = roleRepository.findById(1);

		UserEntity usuarioEntity = new UserEntity(usuario);

		usuarioEntity.setRole(roleEntity.get());
		usuarioEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));
		userRepository.save(usuarioEntity);
	}
	
	public UserDTO update(UserDTO usuario) {
        Optional<UserEntity> targetUser = userRepository.findByUsernameOrEmail(usuario.getUsername(), usuario.getEmail());
		if(targetUser.isPresent()) {
			UserEntity user = targetUser.get();
			  
	        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
	        	user.setPassword(passwordEncoder.encode(usuario.getPassword()));
	        }
	        
	        if (usuario.getPhone_number() != null && !usuario.getPhone_number().isEmpty()) {
	        	user.setPhone_number(usuario.getPhone_number());
	        }

	        return new UserDTO(userRepository.save(user));
		}
		else {
			  throw new RuntimeException("Usuário não encontrado");
		}
	}
	
	public void excluir(String id) {
		Optional<UserEntity> userEntity = userRepository.findById(id);
		if (userEntity.isPresent()){
			UserEntity usuario = userEntity.get();
			userRepository.delete(usuario);
		}


	}
	
	public UserDTO buscarPorId(String id) {
		Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(UserDTO::new).orElseGet(UserDTO::new);
	}
}
