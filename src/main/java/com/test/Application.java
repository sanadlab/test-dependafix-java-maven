package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main Application demonstrating Spring Core usage
 * Testing code repair: This code uses Spring Web annotations (@RestController, @GetMapping)
 * but we only have spring-core and spring-context (no spring-web).
 * This will cause compilation errors that require code changes to remove web dependencies.
 */
@Configuration
@RestController
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
        // The fix requires removing web-related code or adding the dependency
        return greetingService().greet("API User");
    }

    public static class GreetingService {
        public String greet(String name) {
            return "Hello, " + name + "!";
        }
    }
}
