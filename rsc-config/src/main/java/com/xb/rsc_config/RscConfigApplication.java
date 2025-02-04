package com.xb.rsc_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class RscConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(RscConfigApplication.class, args);
	}

}
