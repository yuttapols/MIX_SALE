package com.mixsale.mixsale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mixsale.mixsale.dto.UserDTO;
import com.mixsale.mixsale.service.AuthenticationService;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	@GetMapping("/login")
	public UserDTO login(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "username") String username, @RequestParam(name = "password") String password)
			throws Exception {

		UserDTO user = authenticationService.login(username, password);

		if (null != user) {
			HttpSession session = request.getSession();
			session.removeAttribute(username);
	        session.setAttribute(username, user);
	        session.setMaxInactiveInterval(10*60);
		}

		return user;
	}
	
}
