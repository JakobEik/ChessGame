package com.example.chessgame.model.chess_pieces.pieces;


import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.Piece;
import com.example.chessgame.model.square.Square;

public class Rook extends Piece {
    private static final int value = 500;
    private boolean isFirstMove;
    public Rook(Square square, boolean isWhite) {
        super(square, value, isWhite);
        isFirstMove = true;
    }



    @Override
    protected void calculateMoves(Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        // Right
        addMovesInDirection(x+1, y, 1, 0, board);
        // left
        addMovesInDirection(x-1, y, -1, 0, board);
        // Up
        addMovesInDirection(x, y+1, 0, 1, board);
        // Down
        addMovesInDirection(x, y-1, 0, -1, board);

    }

    @Override
    protected void checkMoved() {
        isFirstMove = false;
    }






}
