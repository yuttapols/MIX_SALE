package com.mixsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mixsale.entity.User;
import com.mixsale.service.AuthenticationService;

@RestController
@RequestMapping(path = "/authentication")
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping(value = {"/getCustomer/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) throws Exception {
		
        User user = authenticationService.getUser(id);
        if(null != user) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
