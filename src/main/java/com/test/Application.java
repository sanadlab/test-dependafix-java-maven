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
     * Greet method with intentional compilation errors.
     * Error 1: toUppercase() - method doesn't exist, should be toUpperCase()
     */
    public String greet(String name) {
        // ERROR: toUppercase() doesn't exist - should be toUpperCase()
        return "Hello, " + name.toUppercase() + "!";
    }

    /**
     * Format method with intentional compilation error.
     * Error 2: formated() - method doesn't exist, should be formatted()
     */
    public String formatGreeting(String template, String name) {
        // ERROR: formated() doesn't exist - should be formatted()
        return template.formated(name);
    }
}
