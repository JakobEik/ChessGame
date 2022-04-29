package com.example.chessgame.model.chess_pieces.pieces;


import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.Piece;
import com.example.chessgame.model.square.Square;

public class Knight extends Piece {
    private static final int value = 300;
    public Knight(Square square, boolean isWhite) {
        super(square, value, isWhite);
    }

    @Override
    protected void calculateMoves(Board board) {

        // One Up Two Right
        addMove(2, 1, board);
        // Two Up One Right
        addMove(1, 2, board);
        // Two Up One Left
        addMove(-1, 2, board);
        // One Up Two Left
        addMove(-2, 1, board);
        // One Down Two Right
        addMove(2, -1, board);
        // Two Down One Right
        addMove(1, -2, board);
        // Two Down One Left
        addMove(-1, -2, board);
        // One Down Two Left
        addMove(-2, -1, board);





    }


    @Override
    protected void checkMoved() {

    }


}
