package com.mixsale.mixsale.service.impl;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mixsale.mixsale.dto.UserDTO;
import com.mixsale.mixsale.dto.request.CustomerRequestDTO;
import com.mixsale.mixsale.entity.CustomerEntity;
import com.mixsale.mixsale.entity.UserEntity;
import com.mixsale.mixsale.repository.AuthenticationRepository;
import com.mixsale.mixsale.repository.CustomerRepository;
import com.mixsale.mixsale.service.CustomerService;
import com.mixsale.mixsale.util.ConstantUtil;
import com.mixsale.mixsale.util.ServiceUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AuthenticationRepository authenticationRepository;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(CustomerRequestDTO body, HttpServletRequest request) throws Exception {
		log.info("######  save  ######");

		HttpSession session = request.getSession();
		try {
			
			if(null != body) {
				
				UserDTO userLogin = (UserDTO) session.getAttribute(body.getAttrId());
				
				Integer seq = customerRepository.getSeqCustomer(body.getCsBranch());
				
				// Save Customer
				CustomerEntity custEntity = new CustomerEntity();
				
				custEntity.setEmpId(body.getEmpId());
				custEntity.setCsSeq(ServiceUtil.checkNullIsNumber(seq) + 1);
				custEntity.setCsName(body.getCsName());
				custEntity.setCsLastname(body.getCsLastname());
				custEntity.setCsIdcard(body.getCsIdcard());
				custEntity.setCsPhone(body.getCsPhone());
				custEntity.setCsBranch(body.getCsBranch());
				custEntity.setCsIdLine(body.getCsIdLine());
				custEntity.setIsActive("1");
				
				custEntity.setCreateBy(null != userLogin ? userLogin.getUserName() : ConstantUtil.SYSTEM);
				custEntity.setCreateDate( new Timestamp(System.currentTimeMillis()));
				
				customerRepository.saveAndFlush(custEntity);
				
				
				// Save UserLogin 
				UserEntity userEntity = new UserEntity();
				
				userEntity.setUsername(body.getEmpId());
				userEntity.setPassword(convertStringToMd5(body.getCsPhone()));
				userEntity.setRole(body.getRole());
				userEntity.setIsActive("1");
				userEntity.setCreateBy(null != userLogin ? userLogin.getUserName() : ConstantUtil.SYSTEM);
				userEntity.setCreateDate( new Timestamp(System.currentTimeMillis()));
				
				authenticationRepository.saveAndFlush(userEntity);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String convertStringToMd5(String password) throws Exception{
		
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(StandardCharsets.UTF_8.encode(password));
		byte[] digest = m.digest();
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digest.length; ++i) {
	          sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1,3));
	    }
		
		return sb.toString();
	}

	
	@Override
	@Transactional(readOnly = true)
	public String genEmpId(String branchId) throws Exception {
		
		Integer seq = customerRepository.getSeqCustomer(branchId);
		
		String prefix = ConstantUtil.BUSSINESS_PREFIX;
		String branch = String.format("%03d", Integer.valueOf(branchId));
		String custSeq = String.format("%05d", ServiceUtil.checkNullIsNumber(seq) + 1);
		String empId = "";
		
		try {
			
			empId = prefix + branch + custSeq;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return empId;
	}
}
