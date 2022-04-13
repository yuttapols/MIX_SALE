package com.mixsale.mixsale.service;

import javax.servlet.http.HttpServletRequest;

import com.mixsale.mixsale.dto.request.CustomerRequestDTO;

public interface CustomerService {

	public void save(CustomerRequestDTO body, HttpServletRequest request) throws Exception;
	
	public String genEmpId(String branchId) throws Exception;
}
