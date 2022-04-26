package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;


public class Queen extends Piece{
    private static final int value = 900;

    public Queen(Square square, boolean isWhite) {
        super(square, value, isWhite);

    }

    /**
     * The moves for the queen is just the combination of the rook and bishop
     * @param board The board
     */
    @Override
    protected void calculateMoves(Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        // Rook
        addMovesInDirection(x+1, y, 1, 0, board);  // Right
        addMovesInDirection(x-1, y, -1, 0, board); // left
        addMovesInDirection(x, y+1, 0, 1, board);  // Up
        addMovesInDirection(x, y-1, 0, -1, board); // Down

        // Bishop
        addMovesInDirection(x+1, y+1, 1, 1, board);   // Upper Right
        addMovesInDirection(x-1, y+1, -1, 1, board);  // Upper Left
        addMovesInDirection(x-1, y-1, -1, -1, board); // Lower Left
        addMovesInDirection(x+1, y-1, 1, -1, board);  // Lower Right


    }

    @Override
    protected void checkMoved() {
        //Does nothing
    }


}
