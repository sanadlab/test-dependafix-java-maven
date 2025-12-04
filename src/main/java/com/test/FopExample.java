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
            // OLD API (FOP 1.0): FopFactory.newInstance() - no parameters
            // This will break when upgraded to FOP 2.2
            FopFactory fopFactory = FopFactory.newInstance();
            
            System.out.println("FOP Factory created successfully with version 1.0 API");
            
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
        // BREAKING CHANGE: This method signature changed in FOP 2.2
        // Old: FopFactory.newInstance()
        // New: FopFactory.newInstance(new File(".").toURI())
        return FopFactory.newInstance();
    }
}

