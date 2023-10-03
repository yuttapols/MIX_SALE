package com.it.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.entity.UserDetailEntity;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Integer>{

	@Query("select i from UserDetailEntity i where i.userId = ?1")
	public Optional<UserDetailEntity> findByUserId(Integer userId);
}
