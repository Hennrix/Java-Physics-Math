package com.hennrix.tools.display;


import javax.swing.*;
import java.awt.*;

public class MainGUI {
    private final JFrame frame;

    public MainGUI() {
        frame = new JFrame("2D Line Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Shapes");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JPanel panelCoordinate = new JPanel(new GridLayout(8, 2));

        JTextField x1Coordinate = new JTextField("0");
        x1Coordinate.setName("x1Coordinate");
        JTextField y1Coordinate = new JTextField("0");
        y1Coordinate.setName("y1Coordinate");
        JTextField z1Coordinate = new JTextField("0");
        z1Coordinate.setName("z1Coordinate");
        JTextField x2Coordinate = new JTextField("100");
        x2Coordinate.setName("x2Coordinate");
        JTextField y2Coordinate = new JTextField("100");
        y2Coordinate.setName("y2Coordinate");
        JTextField z2Coordinate = new JTextField("0");
        z2Coordinate.setName("z2Coordinate");

        panelCoordinate.add(new JLabel("X1:"));
        panelCoordinate.add(x1Coordinate);
        panelCoordinate.add(new JLabel("Y1:"));
        panelCoordinate.add(y1Coordinate);
        panelCoordinate.add(new JLabel("Z1:"));
        panelCoordinate.add(z1Coordinate);
        panelCoordinate.add(new JLabel("X2:"));
        panelCoordinate.add(x2Coordinate);
        panelCoordinate.add(new JLabel("Y2:"));
        panelCoordinate.add(y2Coordinate);
        panelCoordinate.add(new JLabel("Z2:"));
        panelCoordinate.add(z2Coordinate);

        JTextField customTextField = new JTextField();
        customTextField.setName("customTextField");
        panelCoordinate.add(new JLabel("Custom Text:"));
        panelCoordinate.add(customTextField);

        JButton buttonDraw = new JButton("Draw Line");
        buttonDraw.setName("buttonDraw");
        panelCoordinate.add(buttonDraw);

        JButton buttonGetVector = new JButton("Get Vector");
        buttonGetVector.setName("buttonGetVector");
        panelCoordinate.add(buttonGetVector);

        DrawPanel drawPanel = new DrawPanel(x1Coordinate, y1Coordinate, z1Coordinate, x2Coordinate, y2Coordinate, z2Coordinate, customTextField);
        drawPanel.setName("drawPanel");
        drawPanel.setPreferredSize(new Dimension(800, 400));

        frame.setLayout(new BorderLayout());
        frame.add(panelCoordinate, BorderLayout.NORTH);
        frame.add(drawPanel, BorderLayout.CENTER);


        buttonDraw.addActionListener(_ -> drawPanel.repaint());

        buttonGetVector.addActionListener(_ -> {
            try {
                double x1 = Double.parseDouble(x1Coordinate.getText());
                double y1 = Double.parseDouble(y1Coordinate.getText());
                double z1 = Double.parseDouble(z1Coordinate.getText());
                double x2 = Double.parseDouble(x2Coordinate.getText());
                double y2 = Double.parseDouble(y2Coordinate.getText());
                double z2 = Double.parseDouble(z2Coordinate.getText());

                // Calculate the vector components
                double vectorX = x2 - x1;
                double vectorY = y2 - y1;
                double vectorZ = z2 - z1;


                // Format the vector for display
                String vectorString = String.format("Vector:\n⎛ %.2f ⎞\n⎜ %.2f ⎟\n⎝ %.2f ⎠", vectorX, vectorY, vectorZ);
                JOptionPane.showMessageDialog(frame, vectorString, "Vector", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    static class DrawPanel extends JPanel {
        private final JTextField x1Field;
        private final JTextField y1Field;
        private final JTextField x2Field;
        private final JTextField y2Field;

        private final JTextField customTextField;

        public DrawPanel(JTextField x1Field, JTextField y1Field, JTextField ignoredZ1Field, JTextField x2Field, JTextField y2Field, JTextField ignoredZ2Field, JTextField customTextField) {
            this.x1Field = x1Field;
            this.y1Field = y1Field;
            this.x2Field = x2Field;
            this.y2Field = y2Field;
            this.customTextField = customTextField;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            GradientPaint gradient = new GradientPaint(0, 0, Color.RED, panelWidth, panelHeight, Color.BLUE);
            g2d.setPaint(gradient);
            g2d.setStroke(new BasicStroke(10));
            g2d.drawRect(5, 5, panelWidth - 10, panelHeight - 10);

            g.setColor(Color.RED);

            try {
                int x1 = Integer.parseInt(x1Field.getText());
                int y1 = Integer.parseInt(y1Field.getText());
                int x2 = Integer.parseInt(x2Field.getText());
                int y2 = Integer.parseInt(y2Field.getText());

                if (x1 < 0 || x1 > 100 || y1 < 0 || y1 > 100 || x2 < 0 || x2 > 100 || y2 < 0 || y2 > 100) {
                    JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                x1 = scaleCoordinate(x1, panelWidth);
                y1 = scaleCoordinate(y1, panelHeight);
                x2 = scaleCoordinate(x2, panelWidth);
                y2 = scaleCoordinate(y2, panelHeight);

                int offsetX = panelWidth / 2 - (x1 + x2) / 2;
                int offsetY = panelHeight / 2 - (y1 + y2) / 2;

                g.drawLine(x1 + offsetX, y1 + offsetY, x2 + offsetX, y2 + offsetY);

                g.setColor(Color.BLACK);
                g.drawString(customTextField.getText(), 10, 20);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


        private int scaleCoordinate(int value, int maxDst) {
            return value * maxDst / 100;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
