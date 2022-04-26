package com.example.chessgame.model.chess_pieces;


import com.example.chessgame.controller.boards.Board;
import com.example.chessgame.model.square.Square;

public class King extends Piece{

    private static final int value = 10000000;
    private boolean isFirstMove;

    public King(Square square, boolean isWhite) {
        super(square, value, isWhite);
        isFirstMove = true;
    }

    @Override
    protected void calculateMoves(Board board) {
        // Up
        addMove(0, 1, board);
        // Down
        addMove(0, -1, board);
        // Left
        addMove(-1, 0, board);
        // Right
        addMove(1, 0, board);
        // Cross upper right
        addMove(1, 1, board);
        // Cross upper left
        addMove(-1, 1, board);
        // Cross lower left
        addMove(-1, -1, board);
        // Cross lower right
        addMove(+1, -1, board);

    }





    @Override
    protected void checkMoved() {
        isFirstMove = false;
    }


}
