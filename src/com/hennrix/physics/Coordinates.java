package com.hennrix.physics;


/**
 * Coordinates stored in an Array
 */
public class Coordinates {
    private final double positionX;
    private final double positionY;
    private final double positionZ;


    public Coordinates(double x, double y, double z) {
        positionX = x;
        positionY = y;
        positionZ = z;

    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getPositionZ() {
        return positionZ;
    }
}
