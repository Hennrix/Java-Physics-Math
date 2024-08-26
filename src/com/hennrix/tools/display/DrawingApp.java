package com.hennrix.tools.display;

import com.hennrix.tools.display.model.menu.Circle;
import com.hennrix.tools.display.model.menu.DrawingCanvas;
import com.hennrix.tools.display.model.menu.Line;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DrawingApp extends JFrame {
    private final DrawingCanvas canvas;
    private JTextField startXField, startYField, endXField, endYField, centerXField, centerYField, diameterField;
    private JComboBox<String> colorBox, thicknessBox;
    private String drawMode = "Line";

    public DrawingApp() {
        setTitle("Drawing App");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize Canvas
        canvas = new DrawingCanvas();
        JPanel canvasPanel = new JPanel(new GridBagLayout());
        canvasPanel.add(canvas);
        add(canvasPanel, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.setPreferredSize(new Dimension(1000, 100));
        initializeLineFields(inputPanel);
        add(inputPanel, BorderLayout.NORTH);

        // Controls Panel
        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        initializeControlPanel(controlPanel);
        add(controlPanel, BorderLayout.SOUTH);

        // Menu Bar
        setJMenuBar(getMenu());

        setVisible(true);
    }

    private void initializeLineFields(JPanel inputPanel) {
        inputPanel.removeAll();

        startXField = new JTextField("Start X");
        startYField = new JTextField("Start Y");
        endXField = new JTextField("End X");
        endYField = new JTextField("End Y");

        inputPanel.add(new JLabel("Start X:"));
        inputPanel.add(startXField);
        inputPanel.add(new JLabel("Start Y:"));
        inputPanel.add(startYField);
        inputPanel.add(new JLabel("End X:"));
        inputPanel.add(endXField);
        inputPanel.add(new JLabel("End Y:"));
        inputPanel.add(endYField);

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void initializeCircleFields(JPanel inputPanel) {
        inputPanel.removeAll();

        centerXField = new JTextField("Center X");
        centerYField = new JTextField("Center Y");
        diameterField = new JTextField("Diameter");

        inputPanel.add(new JLabel("Center X:"));
        inputPanel.add(centerXField);
        inputPanel.add(new JLabel("Center Y:"));
        inputPanel.add(centerYField);
        inputPanel.add(new JLabel("Diameter:"));
        inputPanel.add(diameterField);

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void initializeControlPanel(JPanel controlPanel) {
        String[] colors = {"Black", "Red", "Green", "Blue"};
        String[] thicknesses = {"1", "2", "3", "4", "5"};

        colorBox = new JComboBox<>(colors);
        thicknessBox = new JComboBox<>(thicknesses);

        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(_ -> {
            try {
                Color color = getColorFromString((String) Objects.requireNonNull(colorBox.getSelectedItem()));
                int thickness = Integer.parseInt((String) Objects.requireNonNull(thicknessBox.getSelectedItem()));

                if ("Line".equals(drawMode)) {
                    int startX = Integer.parseInt(startXField.getText());
                    int startY = Integer.parseInt(startYField.getText());
                    int endX = Integer.parseInt(endXField.getText());
                    int endY = Integer.parseInt(endYField.getText());
                    canvas.addLine(new Line(startX, startY,endX, endY, color, thickness));
                } else {
                    int centerX = Integer.parseInt(centerXField.getText());
                    int centerY = Integer.parseInt(centerYField.getText());
                    int diameter = Integer.parseInt(diameterField.getText());
                    int radius = diameter / 2;
                    canvas.addCircle(new Circle(centerX, centerY, radius, color, thickness));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input");
            }
        });

        JButton clearButton = new JButton("Clear All");
        clearButton.addActionListener(_ -> canvas.clearShapes());

        controlPanel.add(colorBox);
        controlPanel.add(thicknessBox);
        controlPanel.add(drawButton);
        controlPanel.add(clearButton);
    }

    private Color getColorFromString(String colorStr) {
        return switch (colorStr) {
            case "Red" -> Color.RED;
            case "Green" -> Color.GREEN;
            case "Blue" -> Color.BLUE;
            default -> Color.BLACK;
        };
    }

    private JMenuBar getMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuLine = new JMenu("Line");
        JMenuItem drawLine = new JMenuItem("Draw a Line!");
        drawLine.addActionListener(_ -> {
            drawMode = "Line";
            JPanel inputPanel = (JPanel) getContentPane().getComponent(1);
            initializeLineFields(inputPanel);
        });
        menuLine.add(drawLine);

        JMenu menuCircle = new JMenu("Circle");
        JMenuItem drawCircle = new JMenuItem("Draw a Circle!");
        drawCircle.addActionListener(_ -> {
            drawMode = "Circle";
            JPanel inputPanel = (JPanel) getContentPane().getComponent(1);
            initializeCircleFields(inputPanel);
        });
        menuCircle.add(drawCircle);

        menuBar.add(menuLine);
        menuBar.add(menuCircle);

        return menuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawingApp::new);
    }
}