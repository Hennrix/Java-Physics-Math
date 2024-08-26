package com.hennrix.math.model.geometry;
import com.hennrix.math.model.Vector;


public class Line {
    Point pointP;
    Point pointQ;
    public Line(Point pointP, Point pointQ){
        this.pointP = pointP;
        this.pointQ = pointQ;
    }

    public Vector getVector(){
        double x = pointQ.getPositionX()-pointP.getPositionX();
        double y = pointQ.getPositionY()-pointP.getPositionY();
        double z = pointQ.getPositionZ()-pointP.getPositionZ();
        return new Vector(x,y,z);
    }

    public Point getPointP() {
        return pointP;
    }

    public Point getPointQ() {
        return pointQ;
    }

}
