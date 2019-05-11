package com.company;

import com.company.model.Direction;
import com.company.model.SimulatedObject;

import java.util.ArrayList;
import java.util.Arrays;

public class StdinInterpreter {

    public StdinInterpreter() {
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

        SimulatedObject object = new SimulatedObject(Direction.NORTH, x, y);

        plane[x][y] = object;

        return object;
    }

    public static String performSimulation(String commands, SimulatedObject[][] plane, SimulatedObject object)
            throws RuntimeException {

        ArrayList<Integer> numberCommands = new ArrayList<>();

        Arrays.stream(commands.split(",")).forEach(n -> {
            int number = Integer.parseInt(n);
            if (number > 4 || number < 0) {
                throw new NumberFormatException();
            }
            numberCommands.add(number);
        });

        for (int n : numberCommands) {
            if (n == 0) {
                System.out.println("Quiting simulation");
                return "[" + object.getxPosition() + ", " + object.getyPosition() + "]";
            }
            try {
                interpretCommand(n, plane, object);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Object falls down!");
                return "[-1, -1]";
            }
        }

        throw new RuntimeException("No stopping command");
    }

    private static void interpretCommand(int command, SimulatedObject[][] plane, SimulatedObject object)
            throws ArrayIndexOutOfBoundsException {
        switch (command) {
            case 1:
                System.out.println("Moving one step forward...");
                moveObject(plane, object, true);
                break;
            case 2:
                System.out.println("Moving one step backward...");
                moveObject(plane, object, false);
                break;
            case 3:
                System.out.println("Turning 90 degrees clockwise...");
                turnObject(object, true);
                break;
            case 4:
                System.out.println("Turning 90 degrees counterclockwise...");
                turnObject(object, false);
        }
    }

    private static void moveObject(SimulatedObject[][] plane, SimulatedObject object, boolean forward)
            throws ArrayIndexOutOfBoundsException {
        Direction direction = object.getDirection();
        int currX = object.getxPosition();
        int currY = object.getyPosition();

        plane[currX][currY] = null;

        if (forward) {
            switch (direction) {
                case NORTH:
                    plane[currX][currY - 1] = object;
                    object.setyPosition(currY - 1);
                    break;
                case EAST:
                    plane[currX + 1][currY] = object;
                    object.setxPosition(currX + 1);
                    break;
                case SOUTH:
                    plane[currX][currY + 1] = object;
                    object.setyPosition(currY + 1);
                    break;
                case WEST:
                    plane[currX - 1][currY] = object;
                    object.setxPosition(currX - 1);
                    break;
            }
        } else {
            switch (direction) {
                case NORTH:
                    plane[currX][currY + 1] = object;
                    object.setyPosition(currY + 1);
                    break;
                case EAST:
                    plane[currX - 1][currY] = object;
                    object.setxPosition(currX - 1);
                    break;
                case SOUTH:
                    plane[currX][currY - 1] = object;
                    object.setyPosition(currY - 1);
                    break;
                case WEST:
                    plane[currX + 1][currY] = object;
                    object.setxPosition(currX + 1);
                    break;
            }
        }

    }

    private static void turnObject(SimulatedObject object, boolean clockwise) {
        Direction direction = object.getDirection();

        if (clockwise) {
            switch (direction) {
                case NORTH:
                    object.setDirection(Direction.EAST);
                    break;
                case EAST:
                    object.setDirection(Direction.SOUTH);
                    break;
                case SOUTH:
                    object.setDirection(Direction.WEST);
                    break;
                case WEST:
                    object.setDirection(Direction.NORTH);
                    break;
            }
        } else {
            switch (direction) {
                case NORTH:
                    object.setDirection(Direction.WEST);
                    break;
                case WEST:
                    object.setDirection(Direction.SOUTH);
                    break;
                case SOUTH:
                    object.setDirection(Direction.EAST);
                    break;
                case EAST:
                    object.setDirection(Direction.NORTH);
                    break;
            }
        }
    }
}
