package com.hennrix.math.model;

import com.hennrix.math.model.geometry.Line;
import com.hennrix.math.model.geometry.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 */
public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Line getLine(){
        return  new Line(new Point(0,0,0),new Point(x,y,z));
    }

    public double getLength(){
        double number = Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Vector c)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members

        // Compare the data members and return accordingly
        return Double.compare(x, c.x) == 0
                && Double.compare(y, c.y) == 0
                && Double.compare(z, c.z) == 0;
    }


}
