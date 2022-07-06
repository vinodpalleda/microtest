package com.spice.smsotpms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SMSOTPClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SMSOTPClientApplication.class, args);
	}	
}
