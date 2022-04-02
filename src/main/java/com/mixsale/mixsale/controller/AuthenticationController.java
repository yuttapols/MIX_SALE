package com.mixsale.mixsale.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/authentication")
public class AuthenticationController {

	
	@GetMapping("/test")
	public Object test(){
		return HttpStatus.OK;
	}
}
