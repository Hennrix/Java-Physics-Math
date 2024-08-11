package com.hennrix.physics;


/**
 * Coordinates stored in an Array
 */
public class Coordinates {
    private final Long positionX;
    private final Long positionY;
    private final Long positionZ;


    public Coordinates(Long x, Long y, Long z) {
        positionX = x;
        positionY = y;
        positionZ = z;

    }

    public Long getPositionX() {
        return positionX;
    }

    public Long getPositionY() {
        return positionY;
    }

    public Long getPositionZ() {
        return positionZ;
    }
}
