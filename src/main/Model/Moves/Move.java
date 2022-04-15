package main.Model.Moves;


public class Move {

    private final int endX, endY;

    public Move(int endX, int endY) {
        this.endX = endX;
        this.endY = endY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
