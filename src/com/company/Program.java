package com.company;

import com.company.IO.IOHelper;
import com.company.model.SimulatedObject;

import java.io.IOException;

public class Program {


    public Program() {
    }

    void run() {
        IOHelper iOHelper = new IOHelper();

        String stdHeader;
        String stdCommands;
        SimulatedObject[][] plane;
        SimulatedObject object;

        try {
            System.out.println("Reading stdin...");
            iOHelper.readStdin();
            stdHeader = iOHelper.getStdinHeader();
            stdCommands = iOHelper.getStdoutCommands();

            plane = StdinIntepretor.createPlane(stdHeader);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return;
        }

        try {
            //Assumed that that coordinates start at zero (0-3 is the possible range for 4X4 plane)
            object = StdinIntepretor.createSimulatedObject(stdHeader, plane);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Starting position is not on the plane");
            String s = "[-1, -1]";
            try {
                iOHelper.writeToStdout(s);
            } catch (IOException ex) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
            return;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format, Please format you stdin file properly");
            return;
        }

        System.out.println("Running simulation...");
        try {
            String s = StdinIntepretor.performSimulation(stdCommands, plane, object);
            try {
                iOHelper.writeToStdout(s);
            } catch (IOException e) {

            }

        } catch (NumberFormatException e) {
            System.out.println("Incorrect format, Please format you stdin file properly");
        }
    }
}
