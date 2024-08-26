package com.hennrix.tools.display.model.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel {
    private final ArrayList<Line> lines = new ArrayList<>();
    private final ArrayList<Circle> circles = new ArrayList<>();

    public DrawingCanvas() {
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    // Delete the closest shape on right-click
                    deleteShape(e.getX(), e.getY());
                }
            }
        });
    }

    public void addLine(Line line) {
        lines.add(line);
        repaint();
    }

    public void addCircle(Circle circle) {
        circles.add(circle);
        repaint();
    }

    public void clearShapes() {
        lines.clear();
        circles.clear();
        repaint();
    }

    private void deleteShape(int x, int y) {
        // Check if any lines or circles should be removed
        lines.removeIf(line -> line.isNear(x, y));
        circles.removeIf(circle -> circle.isNear(x, y));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw X and Y axis
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); // X-axis
        g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // Y-axis

        for (Line line : lines) {
            g2.setColor(line.color);
            g2.setStroke(new BasicStroke(line.thickness));
            g2.drawLine(line.startX + getWidth() / 2, -line.startY + getHeight() / 2,
                    line.endX + getWidth() / 2, -line.endY + getHeight() / 2);
        }

        for (Circle circle : circles) {
            g2.setColor(circle.color);
            g2.setStroke(new BasicStroke(circle.thickness));
            g2.drawOval(circle.centerX - circle.radius + getWidth() / 2,
                    -circle.centerY - circle.radius + getHeight() / 2,
                    circle.radius * 2, circle.radius * 2);
        }
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }
}