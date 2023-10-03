package com.it.service;

import com.it.model.response.UserModelResponse;

public interface LoginService {

	public UserModelResponse authenLogin(String userName, String password) throws Exception;
}
