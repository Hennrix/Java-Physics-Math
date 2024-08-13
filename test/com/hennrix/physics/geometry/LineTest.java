package com.hennrix.physics.geometry;

import com.hennrix.math.model.Point;
import com.hennrix.math.model.geometry.GeometryVector;
import com.hennrix.physics.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class LineTest {
    //Points get created
    double sqrtOfThree = Math.sqrt(3);
    double sqrtOfFourPointFive = Math.sqrt(4.5);
    Point startPoint = new TestPoint(0, 0);
    Point endPointFiveAwayY = new TestPoint(0, 5);
    Point endPointTwoAwayY = new TestPoint(0, 2);
    Point endPointTwoAwayX = new TestPoint(2, 0);
    Point endPointFiveAwayX = new TestPoint(5, 0);
    Point endPointThreeAway = new TestPoint(sqrtOfFourPointFive, sqrtOfFourPointFive);
    Point endPointTwoAwayZ = new TestPoint(new Coordinates(0, 0, 2));
    Point endPointFiveAwayZ = new TestPoint(new Coordinates(0, 0, 5));
    Point endPointThreeAway_3D = new TestPoint(new Coordinates(sqrtOfThree, sqrtOfThree, sqrtOfThree));
    //Solutions to those Points
    double[] solutionsLineLength = {5,2,2,5,3,2,5,3};
    //The Points are now given to Lines in an Array
    Line[] testLines = {new Line(startPoint, endPointFiveAwayY),
            new Line(startPoint, endPointTwoAwayY),
            new Line(startPoint, endPointTwoAwayX),
            new Line(startPoint, endPointFiveAwayX),
            new Line(startPoint, endPointThreeAway),
            new Line(startPoint, endPointTwoAwayZ),
            new Line(startPoint, endPointFiveAwayZ),
            new Line(startPoint, endPointThreeAway_3D)};
    GeometryVector[] solutionsVector = new GeometryVector[] {
            new GeometryVector(0, 5),
            new GeometryVector(0, 2),
            new GeometryVector(2, 0),
            new GeometryVector(5, 0),
            new GeometryVector(Math.sqrt(4.5), Math.sqrt(4.5)),
            new GeometryVector(0, 0, 2),
            new GeometryVector(0, 0, 5),
            new GeometryVector(Math.sqrt(3), Math.sqrt(3), Math.sqrt(3))
    };


    @Test
    void getVector() {
        int i = 0;
        for (Line line : testLines) {
            Assertions.assertTrue(line.getVector().equals(solutionsVector[i]));
            i++;
        }
    }
    @Test
    void getLengthTest() {
        int i = 0;
        for (Line line : testLines) {
            Assertions.assertEquals(line.getVector().getLength(), solutionsLineLength[i]);
            i++;
        }
    }
}