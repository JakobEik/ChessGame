package com.example.chessgame.model.chess_pieces.pieces;


import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.Piece;
import com.example.chessgame.model.square.Square;

public class Bishop extends Piece {
    private static final int value = 300;

    public Bishop(Square square, boolean isWhite) {
        super(square, value, isWhite);
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
