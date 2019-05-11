package com.company.model;

public class SimulatedObject {
    private Direction direction;
    private int[][] position;

    public SimulatedObject(Direction direction, int[][] position) {
        this.direction = direction;
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
