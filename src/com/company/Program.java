package com.company;

import com.company.IO.IOHelper;
import com.company.model.SimulatedObject;

import java.io.IOException;

public class Program {

    private SimulatedObject[][] plane;

    public Program() {
    }

    void run() {
        System.out.println("Running simulation...");
        IOHelper iOHelper = new IOHelper();

        String stdHeader;

        try {
            System.out.println("Reading stdin...");
            iOHelper.readStdin();
            stdHeader = iOHelper.getStdinHeader();
            String stdCommands = iOHelper.getStdoutCommands();

            plane = StdinIntepretor.createPlane(stdHeader);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return;
        }

        try {
            //Assumed that that coordinates start at zero (0-3 is the possible range for 4X4 plane)
            SimulatedObject object = StdinIntepretor.createSimulatedObject(stdHeader, plane);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Starting position is not on the plane");
            System.out.println("Should write [-1, -1] to console");
        }
    }
}
