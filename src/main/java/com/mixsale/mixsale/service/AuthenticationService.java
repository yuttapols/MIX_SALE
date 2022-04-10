package com.mixsale.mixsale.service;

import com.mixsale.mixsale.dto.UserDTO;

public interface AuthenticationService {

	public UserDTO login(String userName, String password) throws Exception;
}
