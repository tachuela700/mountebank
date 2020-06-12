package com.autentia.mountebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients         // This annotation enables feign client.
public class MountebankWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MountebankWebApplication.class, args);
	}

}
