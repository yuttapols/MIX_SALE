package com.mixsale.mixsale.controller;

import java.io.PrintWriter;
import java.util.Date;

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
	
	@GetMapping("/doSession")
	public String doSession(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "attrId") String attrId)
			throws Exception {
		
		HttpSession session = request.getSession();
		UserDTO username = (UserDTO) session.getAttribute(attrId);
		String result = "0";
		if (null != username) {
			result = "1";
		}

		return result;
	}
}
