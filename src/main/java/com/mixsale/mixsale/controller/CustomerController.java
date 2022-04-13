package com.mixsale.mixsale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mixsale.mixsale.dto.UserDTO;
import com.mixsale.mixsale.dto.request.CustomerRequestDTO;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	
	@PostMapping("/save")
	public void save(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomerRequestDTO body)
			throws Exception {

		if(null != body) {
			HttpSession session = request.getSession();
			UserDTO userLogin = (UserDTO) session.getAttribute(body.getAttrId());
		}	
	}
}
