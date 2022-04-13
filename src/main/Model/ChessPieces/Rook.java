package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;


public class Rook extends Piece{
    private static final int value = 500;
    private boolean isFirstMove;
    public Rook(Square square, boolean isWhite) {
        super(square, value, isWhite);
        isFirstMove = true;
    }

    @Override
    protected void calculateMoves(Square square, Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        // Right
        int i = 1;
        while(x+i <= 7){
            addMove(x+i, y);
            i++;
        }

        // Left
        i = 1;
        while (x-i >= 0){
            addMove(x-i, y);
            i++;
        }

        // Down
        i = 1;
        while(y-i >= 0){
            addMove(x, y-i);
            i++;
        }

        // Up
        i = 1;
        while (y+i <= 7){
            addMove(x, y+i);
            i++;
        }
    }

    @Override
    protected void move() {
        isFirstMove = false;
    }

    /**
     * Helper method for the calculateMoves method
     */
    private void addMove(int x, int y){
        Move move = createMove(x, y);
        if (isLegalMove(move)) moves.add(move);
    }




}
