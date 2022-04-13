package com.mixsale.mixsale.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixsale.mixsale.dto.request.CustomerRequestDTO;
import com.mixsale.mixsale.entity.CustomerEntity;
import com.mixsale.mixsale.repository.CustomerRepository;
import com.mixsale.mixsale.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void save(CustomerRequestDTO body) throws Exception {

		
		// Save
		try {
			
			CustomerEntity entity = new CustomerEntity();
			
			entity.setEmpId(null);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
