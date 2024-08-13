package com.hennrix.physics.geometry;
import com.hennrix.math.interfaces.Point;
import com.hennrix.math.interfaces.geometry.GeometryVector;



public class Line {
    Point pointP;
    Point pointQ;
    public Line(Point pointP, Point pointQ){
        this.pointP = pointP;
        this.pointQ = pointQ;
    }

    public GeometryVector getVector(){
        double x = pointQ.getPositionX()-pointP.getPositionX();
        double y = pointQ.getPositionY()-pointP.getPositionY();
        double z = pointQ.getPositionZ()-pointP.getPositionZ();
        return new GeometryVector(x,y,z);
    }


}
