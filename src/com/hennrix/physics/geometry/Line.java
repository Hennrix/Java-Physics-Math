package com.hennrix.physics.geometry;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Line {
    Point pointP;
    Point pointQ;
    public Line(Point pointP, Point pointQ){
        this.pointP = pointP;
        this.pointQ = pointQ;
    }
    public double getLength(){
        double x = pointP.getPositionX()- pointQ.getPositionX();
        double y = pointP.getPositionY()- pointQ.getPositionY();
        double z = pointP.getPositionZ()- pointQ.getPositionZ();
        double number = Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
