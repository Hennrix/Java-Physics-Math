package com.hennrix.tools.display.model.menu;

import java.awt.*;

public class Line {
    int startX, startY, endX, endY, thickness;
    Color color;

    public Line(int startX, int startY, int endX, int endY, Color color, int thickness) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        this.thickness = thickness;
    }

    public boolean isNear(int x, int y) {
        // Check if the point (x, y) is near this line
        return new Rectangle(Math.min(startX, endX) - 5, Math.min(startY, endY) - 5,
                Math.abs(startX - endX) + 10, Math.abs(startY - endY) + 10).contains(x, y);
    }
}