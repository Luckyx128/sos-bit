package com.solution.sos_bit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.sos_bit.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	Optional<RoleEntity> findById(long i);
	
}
