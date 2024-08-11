package com.hennrix.physics.geometry;

import com.hennrix.physics.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineTest {
    //Points get created
    double sqrtOfThree = Math.sqrt(3);
    double sqrtOfFourPointFive = Math.sqrt(4.5);
    Point startPoint = new Point(0, 0);
    Point endPointFiveAwayY = new Point(0, 5);
    Point endPointTwoAwayY = new Point(0, 2);
    Point endPointTwoAwayX = new Point(2, 0);
    Point endPointFiveAwayX = new Point(5, 0);
    Point endPointThreeAway = new Point(sqrtOfFourPointFive, sqrtOfFourPointFive);
    Point endPointTwoAwayZ = new Point(new Coordinates(0, 0, 2));
    Point endPointFiveAwayZ = new Point(new Coordinates(0, 0, 5));
    Point endPointThreeAway_3D = new Point(new Coordinates(sqrtOfThree, sqrtOfThree, sqrtOfThree));
    //Solutions to those Points
    double[] solutions = {5,2,2,5,3,2,5,3};
    //The Points are now given to Lines in an Array
    Line[] testLines = {new Line(startPoint, endPointFiveAwayY),
            new Line(startPoint, endPointTwoAwayY),
            new Line(startPoint, endPointTwoAwayX),
            new Line(startPoint, endPointFiveAwayX),
            new Line(startPoint, endPointThreeAway),
            new Line(startPoint, endPointTwoAwayZ),
            new Line(startPoint, endPointFiveAwayZ),
            new Line(startPoint, endPointThreeAway_3D)};

    @Test
    void getLengthTest() {
        int i = 0;
        for (Line line : testLines) {
            Assertions.assertEquals(line.getLength(),solutions[i]);
            i++;
        }
    }
}