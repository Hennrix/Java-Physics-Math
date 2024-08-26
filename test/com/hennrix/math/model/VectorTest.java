package com.hennrix.math.model;

import com.hennrix.math.model.geometry.Line;
import com.hennrix.math.model.geometry.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void getLine() {
        Vector vector = new Vector(10, 20);
        assertEquals(new Line(new Point(0, 0, 0), new Point(10, 20, 0)).getPointP().getPositionX(), vector.getLine().getPointP().getPositionX());
        assertEquals(new Line(new Point(0, 0, 0), new Point(10, 20, 0)).getPointP().getPositionY(), vector.getLine().getPointP().getPositionY());
        assertEquals(new Line(new Point(0, 0, 0), new Point(10, 20, 0)).getPointP().getPositionZ(), vector.getLine().getPointP().getPositionZ());
        assertEquals(new Line(new Point(0, 0, 0), new Point(10, 20, 0)).getPointQ().getPositionX(), vector.getLine().getPointQ().getPositionX());
        assertEquals(new Line(new Point(0, 0, 0), new Point(10, 20, 0)).getPointQ().getPositionY(), vector.getLine().getPointQ().getPositionY());
        assertEquals(new Line(new Point(0, 0, 0), new Point(10, 20, 0)).getPointQ().getPositionZ(), vector.getLine().getPointQ().getPositionZ());
    }
}