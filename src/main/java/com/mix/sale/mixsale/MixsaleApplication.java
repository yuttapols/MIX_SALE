package com.mix.sale.mixsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MixsaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MixsaleApplication.class, args);
	}

}
