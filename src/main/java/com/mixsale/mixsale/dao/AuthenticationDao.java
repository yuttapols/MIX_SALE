package com.mixsale.mixsale.dao;

import com.mixsale.mixsale.dto.UserDTO;

public interface AuthenticationDao {

	public UserDTO login(String userName, String password) throws Exception;
}
