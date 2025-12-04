package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application for DependaFix Testing
 * 
 * This version has compilation errors that require JAVA CODE FIXES:
 * - Typo in method call: toUppercase() should be toUpperCase()
 * - Using non-existent String method: formated() should be formatted()
 * 
 * These errors CANNOT be fixed by changing pom.xml - the code itself must be modified.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Greet method - fixed for FOP test baseline.
     */
    public String greet(String name) {
        return "Hello, " + name.toUpperCase() + "!";
    }

    /**
     * Format method - fixed for FOP test baseline.
     */
    public String formatGreeting(String template, String name) {
        return template.formatted(name);
    }
}
