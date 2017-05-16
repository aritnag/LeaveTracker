package com.vmware.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@PropertySource("file:${app.home}")
public class ProjectsApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "hierarchy-server");
		SpringApplication.run(ProjectsApplication.class, args);
	}
}
