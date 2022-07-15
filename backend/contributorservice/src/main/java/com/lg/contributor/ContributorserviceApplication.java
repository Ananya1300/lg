package com.lg.contributor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ContributorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContributorserviceApplication.class, args);
	}

}
