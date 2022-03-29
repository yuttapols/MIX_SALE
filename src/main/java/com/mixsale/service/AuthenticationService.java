package com.mixsale.service;

import org.springframework.stereotype.Service;

import com.mixsale.entity.User;

@Service
public interface AuthenticationService {
	
	public User getUser(Long id) throws Exception;

}
