package com.hennrix.math.interfaces;

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
    public boolean equals(Vector other) {
        return x == other.x && y == other.y && z == other.z;
    }
    public double getLength(){
        double number = Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
