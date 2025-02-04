package com.xb.rsc_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RscInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RscInfoApplication.class, args);
	}

}
