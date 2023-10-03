package com.it.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.model.UserDetailModel;
import com.it.model.response.UserModelResponse;
import com.it.repository.UserDetailRepository;
import com.it.repository.UserRepository;
import com.it.service.LoginService;
import com.it.utils.PasswordEncryptorUtils;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserModelResponse authenLogin(String userName, String password) throws Exception {

		Optional<UserEntity> userEntity = userRepository.findByUserName(userName);
		UserModelResponse res = null;
		// isPresent = เช็คว่ามีข้อมูลไหม
		if(userEntity.isPresent()) {
			if(PasswordEncryptorUtils.checkPassword(password, userEntity.get().getPassword())) {
				res = modelMapper.map(userEntity.get(), UserModelResponse.class);
				
				Optional<UserDetailEntity> userDetailEntity =  userDetailRepository.findByUserId(userEntity.get().getUserId());
				
				// ดึงข้อมูลจาก userDetail แล้ว Retrun กลับไปยังหน้าบ้าน
				if(userDetailEntity.isPresent()) {
					UserDetailModel userDetail = modelMapper.map(userDetailEntity.get(), UserDetailModel.class);
					res.setUserDetail(userDetail);
				}
			}
		}
		
		return res;
	}

}
