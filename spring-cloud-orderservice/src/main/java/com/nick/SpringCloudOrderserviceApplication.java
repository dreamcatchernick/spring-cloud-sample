package com.nick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudOrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderserviceApplication.class, args);
	}
}
