package com.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Application
 */
public class ApplicationTest {

    @Test
    public void testGreetingService() {
        Application.GreetingService service = new Application.GreetingService();
        String result = service.greet("World");
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testGreetingServiceWithDifferentName() {
        Application.GreetingService service = new Application.GreetingService();
        String result = service.greet("DependaFix");
        assertEquals("Hello, DependaFix!", result);
    }
}

