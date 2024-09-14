package com.karthik.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.karthik.taskmanager.dao")
@EntityScan(basePackages = "com.karthik.taskmanager.entity")
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}
