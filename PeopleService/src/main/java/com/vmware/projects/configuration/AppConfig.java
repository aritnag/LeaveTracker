package com.vmware.projects.configuration;

import javax.inject.Inject;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.vmware.projects.service.PeopleService;


@Configuration
@PropertySource("file:${app.home}")
public class AppConfig {
	
	@Inject Environment env;
	protected RestTemplate restTemplate; 
	
   	@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
		return restTemplate= new RestTemplate();
    }
	
   	@Bean
    public PeopleService peopleService() {
        return new PeopleService(restTemplate, env.getProperty("user.service"), env.getProperty("role.service"), env.getProperty("hierarchy.service")
        		, env.getProperty("project.service"), env.getProperty("leave.service"));
    }
}
