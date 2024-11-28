package com.solution.sos_bit.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.solution.sos_bit.entity.UserEntity;

public class UserDetailsImpl implements UserDetails{

	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	
	public UserDetailsImpl(String name, String username, String password, String email,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UserEntity usuario) {
		
		return new UserDetailsImpl(
				usuario.getName(), 
				usuario.getUsername(),
				usuario.getPassword(),
				usuario.getEmail(), 
				new ArrayList<>());
	}
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
