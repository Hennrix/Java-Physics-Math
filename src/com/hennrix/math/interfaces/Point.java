package com.hennrix.math.interfaces;

import com.hennrix.physics.Coordinates;

public abstract class Point {
    private final double positionX;
    private final double positionY;
    private final double positionZ;


    /**
     * @param coordinates Three Coordinates that are Typical 'X,Y and Z' Each representing one Position of the Point
     */
    public Point(Coordinates coordinates) {
        positionX = coordinates.getPositionX();
        positionY = coordinates.getPositionY();
        positionZ = coordinates.getPositionZ();
    }

    /**
     * Creates a Point with the Coordinates and basically a PositionZ with '0' as Value
     */
    public Point(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        positionZ = 0L;
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
