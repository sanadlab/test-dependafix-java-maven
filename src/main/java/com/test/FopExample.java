package com.test;

import org.apache.fop.apps.FopFactory;

import java.io.File;

/**
 * Example class demonstrating FOP usage with version 1.0 API.
 * 
 * This class uses the OLD API: FopFactory.newInstance()
 * When upgraded to FOP 2.2, this will break because:
 * - Old API: FopFactory.newInstance()
 * - New API: FopFactory.newInstance(new File(".").toURI())
 * 
 * This is a breaking change that requires Java code modification, not just pom.xml.
 */
public class FopExample {

    public static void main(String[] args) {
        try {
            // NEW API (FOP 2.2): FopFactory.newInstance(new File(".").toURI())
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            
            System.out.println("FOP Factory created successfully with version 2.2 API");
            
        } catch (Exception e) {
            System.err.println("Error creating FOP Factory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Method that uses the old FOP API.
     * This will cause compilation errors when FOP is upgraded to 2.2.
     */
    public FopFactory createFopFactory() {
        // NEW API (FOP 2.2): FopFactory.newInstance(new File(".").toURI())
        return FopFactory.newInstance(new File(".").toURI());
    }
}