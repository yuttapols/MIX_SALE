package com.mixsale.mixsale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixsale.mixsale.dao.AuthenticationDao;
import com.mixsale.mixsale.dto.UserDTO;
import com.mixsale.mixsale.service.impl.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	AuthenticationDao authenticationDao;
	
	@Override
	public UserDTO login(String userName, String password) throws Exception {
		
		return authenticationDao.login(userName, password);
	}
}
