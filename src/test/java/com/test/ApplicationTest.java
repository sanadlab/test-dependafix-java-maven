package com.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Application
 */
public class ApplicationTest {

    @Test
    public void testGreet() {
        Application app = new Application();
        String result = app.greet("World");
        assertEquals("Hello, WORLD!", result);
    }

    @Test
    public void testFormatGreeting() {
        Application app = new Application();
        String result = app.formatGreeting("Hi %s!", "DependaFix");
        assertEquals("Hi DependaFix!", result);
    }
}
