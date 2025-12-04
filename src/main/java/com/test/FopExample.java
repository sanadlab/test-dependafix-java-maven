package com.test;

import org.apache.fop.apps.FopFactory;

public class FopExample {

    public static void main(String[] args) {
        try {
            FopFactory fopFactory = FopFactory.newInstance();
            System.out.println("FOP Factory created successfully");
        } catch (Exception e) {
            System.err.println("Error creating FOP Factory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public FopFactory createFopFactory() {
        return FopFactory.newInstance();
    }
}
