package com.mixsale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

//    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    
//    @Autowired
//    AuthenticationService authenticationService;

	@GetMapping("/login")
	public void login(String username, String password) throws Exception{
		
	}


}
