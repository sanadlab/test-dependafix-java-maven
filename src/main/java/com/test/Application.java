package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Main Spring Boot Application for DependaFix Testing
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // Using Spring Boot 3.x API with 2.7.x version - will cause compilation error
        // Remove() method was added in Spring Boot 3.0
        throw new RuntimeException("Test compilation error");
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}

