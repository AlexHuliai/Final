package com.running.runningPall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.running.repository")
@EntityScan(basePackages="com.running.entity")
@ComponentScan(basePackages="com.running")
@SpringBootApplication
public class RunningPallApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunningPallApplication.class, args);
	}

}
