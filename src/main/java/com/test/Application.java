package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Main Application demonstrating Spring Core usage
 * This tests Spring Core 5.3.24 compatibility with JDK 11
 * Spring Core 6.0+ requires Java 17+, so upgrading to 6.0.8 with JDK 11 will fail
 */
@Configuration
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

    public static class GreetingService {
        public String greet(String name) {
            return "Hello, " + name + "!";
        }
    }
}
