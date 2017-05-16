package com.vmware.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import com.vmware.projects.service.PeopleService;

@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@PropertySource("file:${app.home}")
public class ProjectsApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "composite-server");
		SpringApplication.run(ProjectsApplication.class, args);
	}
	
	
    
}
