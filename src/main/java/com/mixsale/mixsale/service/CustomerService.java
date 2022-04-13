package com.mixsale.mixsale.service;

import com.mixsale.mixsale.dto.request.CustomerRequestDTO;

public interface CustomerService {

	public void save(CustomerRequestDTO body) throws Exception;
}
