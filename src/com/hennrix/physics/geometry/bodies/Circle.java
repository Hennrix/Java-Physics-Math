package com.hennrix.physics.geometry.bodies;

public class Circle {
    private final double diameter;
    private final double positionX;
    private final double positionY;
    private final double positionZ;

    public Circle(double positionX, double positionY,  double positionZ,double radius) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.diameter = radius * 2;
        this.positionZ = positionZ;
    }


    public double getDiameter() {
        return diameter;
    }

    /**
     * Will be needed to compare Positions
    public double getPositionX() {
        return positionX;
    }


    public double getPositionY() {
        return positionY;
    }


    public double getPositionZ() {
        return positionZ;
    }
    **/



    public double getRadius() {
        return diameter / 2;
    }
    public double getArea(){
        return Math.PI * getRadius() * getRadius();
    }
    public double getCircumference(){
        return 2 * Math.PI * getRadius();
    }
}
