package com.company.model;

public class SimulatedObject {
    private Direction direction;
    private int xPosition;
    private int yPosition;

    public SimulatedObject(Direction direction, int xPosition, int yPosition) {
        this.direction = direction;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
