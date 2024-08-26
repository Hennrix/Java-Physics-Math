package com.hennrix.tools.display.model.menu;

import java.awt.*;

public class Circle {
    int centerX, centerY, radius, thickness;
    Color color;

    public Circle(int centerX, int centerY, int radius, Color color, int thickness) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
        this.thickness = thickness;
    }

    public boolean isNear(int x, int y) {
        // Check if the point (x, y) is near this circle
        double distance = Math.hypot(centerX - x, centerY - y);
        return Math.abs(distance - radius) < 10;
    }
}