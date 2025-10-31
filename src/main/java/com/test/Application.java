package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application for DependaFix Testing
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
    
    // This will cause compilation error - undefined method
    public void testCompilationError() {
        String result = undefinedMethod("test");
    }
}

