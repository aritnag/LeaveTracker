package com.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@PropertySource("file:${app.home}")
public class ProjectServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "project-server");
		SpringApplication.run(ProjectServiceApplication.class, args);
	}
}
