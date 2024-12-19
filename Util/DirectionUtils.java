package com.example.Util;

public class DirectionUtils {

    private static final int MOVE_STEP = 1;

    public static int[] calculateNewPosition(int[] currentPos, String direction) {
        if (currentPos == null || currentPos.length < 2) {
            throw new IllegalArgumentException("currentPos must be a non-null array with at least two elements");
        }

        int[] newPos = currentPos.clone();
        switch (direction) {
            case "up":
                newPos[1] -= MOVE_STEP;
                break;
            case "down":
                newPos[1] += MOVE_STEP;
                break;
            case "left":
                newPos[0] -= MOVE_STEP;
                break;
            case "right":
                newPos[0] += MOVE_STEP;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        return newPos;
    }
}
