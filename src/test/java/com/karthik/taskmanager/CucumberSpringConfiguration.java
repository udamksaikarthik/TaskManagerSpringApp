package com.karthik.taskmanager;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

// Point to your main Spring Boot application class
@CucumberContextConfiguration
@SpringBootTest(classes = TaskmanagerApplication.class)
public class CucumberSpringConfiguration {
}
