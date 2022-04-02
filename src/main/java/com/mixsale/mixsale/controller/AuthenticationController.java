package com.mixsale.mixsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mixsale.mixsale.dto.UserDTO;
import com.mixsale.mixsale.service.impl.AuthenticationService;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

	
    @Autowired
    AuthenticationService authenticationService;

	@GetMapping("/login")
	public UserDTO login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) throws Exception{
		
		return authenticationService.login(username, password);
	}
}
