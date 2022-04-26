package main.Model.Moves;


import java.util.Arrays;

public class Move {

    private final int[] endPosition;

    public Move(int endX, int endY) {
        endPosition = new int[]{endX, endY};
    }

    /**
     * Gets the end position for this move.
     *
     * <p>x = getEndPosition()[0]</p>
     * <p>y = getEndPosition()[1]</p>
     *
     * @return Array of integers
     */
    public int[] getEndPosition() {
        return endPosition;
    }

    @Override
    public String toString() {
        return "Move{" +
                "endPosition=" + Arrays.toString(endPosition) +
                '}';
    }
}
