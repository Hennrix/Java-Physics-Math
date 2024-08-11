package com.hennrix.physics.geometry;

import com.hennrix.physics.Coordinates;

public class Point {
    private double positionX;
    private double positionY;
    private double positionZ;


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
    public Point(Long positionX, Long positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        positionZ = 0;
    }
}
