package com.running.config;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories(basePackages="com.running.repository")
@EntityScan(basePackages="com.running.entity")
public class ApplicationConfig {
}
