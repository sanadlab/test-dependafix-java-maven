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
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testGreetWithDifferentName() {
        Application app = new Application();
        String result = app.greet("DependaFix");
        assertEquals("Hello, DependaFix!", result);
    }
}

