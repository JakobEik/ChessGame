package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;


public class Bishop extends Piece{
    private static final int value = 300;

    public Bishop(Square square, boolean isWhite) {
        super(square, value, isWhite);
    }

    public Bishop(boolean isWhite) {
        super(value, isWhite);
    }




    @Override
    protected void calculateMoves(Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        // Upper Right
        addMovesInDirection(x+1, y+1, 1, 1, board);
        // Upper Left
        addMovesInDirection(x-1, y+1, -1, 1, board);
        // Lower Left
        addMovesInDirection(x-1, y-1, -1, -1, board);
        // Lower Right
        addMovesInDirection(x+1, y-1, 1, -1, board);


    }

    @Override
    protected void checkMoved() {

    }






}
