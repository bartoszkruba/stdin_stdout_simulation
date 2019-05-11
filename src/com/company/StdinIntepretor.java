package com.company;

import com.company.model.Direction;
import com.company.model.SimulatedObject;

public class StdinIntepretor {

    public StdinIntepretor() {
    }

    // Assumed that no decimal coordinates should be allowed
    public static SimulatedObject[][] createPlane(String stdinHeader) {
        String[] numbersInHeader = stdinHeader.split(",");

        int width = Integer.parseInt(numbersInHeader[0]);
        int height = Integer.parseInt(numbersInHeader[1]);

        System.out.println("Creating new plane with size " + width + "x" + height + "...");

        return new SimulatedObject[width][height];
    }

    public static SimulatedObject createSimulatedObject(String stdinHeader, SimulatedObject[][] plane)
            throws ArrayIndexOutOfBoundsException {
        String[] numbersInHeader = stdinHeader.split(",");
        int x = Integer.parseInt(numbersInHeader[2]);
        int y = Integer.parseInt(numbersInHeader[3]);

        System.out.println("Creating object with starting position " + x + "x" + y + "...");

        SimulatedObject object = new SimulatedObject(Direction.NORTH, new int[x][y]);

        plane[x][y] = object;

        return object;
    }
}
