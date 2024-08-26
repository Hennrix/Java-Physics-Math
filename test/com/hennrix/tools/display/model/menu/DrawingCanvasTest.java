package com.hennrix.tools.display.model.menu;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawingCanvasTest {

    @Test
    void addLine() {
        DrawingCanvas testCanvas = new DrawingCanvas();
        Line line = new Line(10, 20, 30, 40, Color.BLACK, 2);
        testCanvas.addLine(line);
        assertEquals(1, testCanvas.getLines().size());
        assertEquals(line, testCanvas.getLines().getFirst());
    }

    @Test
    void addCircle() {
        DrawingCanvas testCanvas = new DrawingCanvas();
        Circle circle = new Circle(10, 20, 30, Color.BLACK, 2);
        testCanvas.addCircle(circle);
        assertEquals(1, testCanvas.getCircles().size());
        assertEquals(circle, testCanvas.getCircles().getFirst());
    }

    @Test
    void clearShapes() {
        DrawingCanvas testCanvas = new DrawingCanvas();
        Line line = new Line(10, 20, 30, 40, Color.BLACK, 2);
        Circle circle = new Circle(10, 20, 30, Color.BLACK, 2);
        testCanvas.addLine(line);
        testCanvas.addCircle(circle);
        testCanvas.clearShapes();
        assertEquals(0, testCanvas.getLines().size());
        assertEquals(0, testCanvas.getCircles().size());
    }

    @Test
    void paintComponent() {
        DrawingCanvas testCanvas = new DrawingCanvas();
        Line line = new Line(10, 20, 30, 40, Color.BLACK, 2);
        Circle circle = new Circle(10, 20, 30, Color.BLACK, 2);
        testCanvas.addLine(line);
        testCanvas.addCircle(circle);
        testCanvas.repaint();
        assertEquals(1, testCanvas.getLines().size());
        assertEquals(1, testCanvas.getCircles().size());
    }
}