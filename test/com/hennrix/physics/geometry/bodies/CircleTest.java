package com.hennrix.physics.geometry.bodies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CircleTest {

    @Test
    void getDiameter() {
        Circle circle = new Circle(10, 20,0, 30);
        Assertions.assertEquals(60, circle.getDiameter(), 0.01);
    }

    @Test
    void getRadius() {
        Circle circle = new Circle(10, 20,0, 15);
        Assertions.assertEquals(15, circle.getRadius(), 0.01);
    }

    @Test
    void getArea() {
        Circle circle = new Circle(10, 20,0, 15);
        Assertions.assertEquals(Math.PI * 15 * 15, circle.getArea(), 0.01);
    }

    @Test
    void getCircumference() {
        Circle circle = new Circle(10, 20,0, 15);
        Assertions.assertEquals(2 * Math.PI * 15, circle.getCircumference(), 0.01);
    }
}