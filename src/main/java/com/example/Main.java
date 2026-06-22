package com.example;

import org.kohsuke.github.GHCompare;
import org.kohsuke.github.GitHub;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    private String owner;
    private String repo;
    private String hash;

    public Main(String owner, String repo, String hash) {
        this.owner = owner;
        this.repo = repo;
        this.hash = hash;
    }

    public boolean checkBranchStatus(String branch) {
        try {
            GHCompare compare = GitHub.connect().getRepository(owner + '/' + repo).getCompare(branch, hash);
            GHCompare.Status status = compare.getStatus();
            return status == GHCompare.Status.identical || status == GHCompare.Status.behind;
        } catch (FileNotFoundException x) {
            // For example, that branch does not exist in this repository.
            return false;
        } catch (IOException e) {
            // Handle other I/O errors (network issues, authentication errors, etc.)
            return false;
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Main <owner> <repo> <branch> <hash>");
            System.exit(1);
        }

        String owner = args[0];
        String repo = args[1];
        String branch = args[2];
        String hash = args[3];

        Main ghc = new Main(owner, repo, hash);
        boolean result = ghc.checkBranchStatus(branch);
        System.out.println("Branch status check result: " + result);
    }
}