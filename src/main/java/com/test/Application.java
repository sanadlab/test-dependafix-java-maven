package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main Application for DependaFix Testing - Code Repair Required
 * 
 * This code uses Spring Web annotations (@RestController, @GetMapping) but
 * the pom.xml only includes spring-core and spring-context (no spring-web).
 * 
 * This will cause compilation errors that require CODE CHANGES to fix:
 * - Remove @RestController annotation
 * - Remove @GetMapping method
 * - Remove web-related imports
 * 
 * This cannot be fixed by just adding spring-web to pom.xml - the code
 * needs to be refactored to work without web dependencies.
 */
@Configuration
@RestController
@RequestMapping("/api")
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        
        GreetingService service = context.getBean(GreetingService.class);
        System.out.println(service.greet("World"));
        
        context.close();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @GetMapping("/greet")
    public String greetEndpoint() {
        // This method uses @GetMapping which requires spring-web dependency
        // Since we don't have spring-web, this will fail compilation
        // The fix requires removing this method and web annotations
        return greetingService().greet("API User");
    }

    public static class GreetingService {
        public String greet(String name) {
            return "Hello, " + name + "!";
        }
    }
}

