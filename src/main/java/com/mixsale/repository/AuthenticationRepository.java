package com.mixsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mixsale.entity.User;

public interface AuthenticationRepository extends JpaRepository<User, Long>{
	
	@Query("select t from User t where t.id = ?1")
	User findByid(Long id);

}
