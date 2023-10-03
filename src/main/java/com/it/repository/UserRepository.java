package com.it.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public Optional<UserEntity> findByUserName(String userName);
	
}
