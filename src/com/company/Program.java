package com.company;

import com.company.IO.IOHelper;

import java.io.IOException;

public class Program {

    public Program() {
    }

    void run() {
        System.out.println("Running simulation...");
        IOHelper iOHelper = new IOHelper();

        try {
            iOHelper.readStdin();
            System.out.println(iOHelper.getStdinHeader());
            System.out.println(iOHelper.getStdoutCommands());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
