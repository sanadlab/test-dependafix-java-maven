package com.test;

import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryConfig;

public class FopExample {

    public static void main(String[] args) {
        try {
            FopFactoryConfig config = new FopFactoryConfig();
            FopFactory fopFactory = FopFactory.newInstance(config);
            System.out.println("FOP Factory created successfully");
        } catch (Exception e) {
            System.err.println("Error creating FOP Factory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public FopFactory createFopFactory() {
        FopFactoryConfig config = new FopFactoryConfig();
        return FopFactory.newInstance(config);
    }
}