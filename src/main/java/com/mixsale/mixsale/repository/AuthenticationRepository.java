package com.mixsale.mixsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mixsale.mixsale.entity.UserEntity;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserEntity,Long>{

}
