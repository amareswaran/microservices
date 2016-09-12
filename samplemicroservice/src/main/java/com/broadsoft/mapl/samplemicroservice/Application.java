package com.broadsoft.mapl.samplemicroservice;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.broadsoft.mapl.MaplLoggerFactory;

@SpringBootApplication
//@EnableDiscoveryClient
public class Application {
	private static Logger logger = MaplLoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		logger.info("Sample micro service is starting..!!");
		SpringApplication.run(Application.class, args);		
	}
}