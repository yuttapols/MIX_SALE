package com.mixsale.mixsale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mixsale.mixsale.dto.request.CustomerRequestDTO;
import com.mixsale.mixsale.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/save")
	public void save(HttpServletRequest request, HttpServletResponse response, @RequestBody CustomerRequestDTO body)
			throws Exception {
		
		customerService.save(body, request);
	}
	
	@GetMapping("/genEmpId")
	public String genEmpId(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "branchId") String branchId)
			throws Exception {
		
		return customerService.genEmpId(branchId);
	}
}
