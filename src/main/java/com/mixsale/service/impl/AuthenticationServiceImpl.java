package com.mixsale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mixsale.entity.User;
import com.mixsale.repository.AuthenticationRepository;
import com.mixsale.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	AuthenticationRepository authenticationRepository;
	
	@Override
	public User getUser(Long id) throws Exception {
		
		return authenticationRepository.findByid(id);
	}

}
