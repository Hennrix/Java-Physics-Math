package com.hennrix.physics.geometry;

public class Line {
    Point pointP;
    Point pointQ;
    public Line(Point pointP, Point pointQ){
        this.pointP = pointP;
        this.pointQ = pointQ;
    }
    public double getLength(){
        long x = pointP.getPositionX()- pointQ.getPositionX();
        long y = pointP.getPositionY()- pointQ.getPositionY();
        long z = pointP.getPositionZ()- pointQ.getPositionZ();

        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));

    }


}
