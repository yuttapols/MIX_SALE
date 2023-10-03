package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.ResponseModel;
import com.it.model.response.UserModelResponse;
import com.it.service.LoginService;
import com.it.utils.ConstantsApiResponse;

@RestController
@RequestMapping("/authen")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public ResponseModel login(@RequestParam String username, @RequestParam String password)  {
		
		ResponseModel res = new ResponseModel();
		
		 try {
			 UserModelResponse data = loginService.authenLogin(username, password);
			 res.setData(data);
		} catch (Exception e) {
			// กรณีเกิด Error จะแสดง Error และ status 500
			e.printStackTrace();
			res.setMessage(e.toString());
			return ConstantsApiResponse.getErrorInternalServerError(res);
		}

		return ConstantsApiResponse.getOkResponse(res);
	}
}
