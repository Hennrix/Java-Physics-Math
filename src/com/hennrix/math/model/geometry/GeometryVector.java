package com.hennrix.math.model.geometry;

import com.hennrix.math.model.Vector;

/**
 * knows as a⃗  or b⃗ , holding 2 or three values, for direction, magnitude and in 3rd dimension even angle
 */
public class GeometryVector extends Vector {

    public GeometryVector(double x, double y) {
        super(x,y);
    }
    public GeometryVector(double x, double y, double z) {
        super(x,y,z);
    }
}
