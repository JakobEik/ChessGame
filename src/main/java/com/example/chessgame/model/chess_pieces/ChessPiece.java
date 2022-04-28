package com.example.chessgame.model.chess_pieces;


import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;

import java.util.Collection;
import java.util.List;

public interface ChessPiece {

    /**
     * @return The value for the piece
     * Use for the AI to check how important a piece is
     */
    int getValue();

    int getStartX();

    /**
     * @return The square the piece is on
     */
    Square getSquare();

    void move(Square square);

    /**
     * Gets all legal moves for this piece on a given board
     *
     * @param board The board
     * @return a list of moves for the piece
     */
    List<Move> getMoves(Board board);

    /**
     *
     * @return true if the piece is white, false if the piece is black
     */
    boolean isWhite();

    /**
     * Checks if a move is legal
     * @param move The move
     * @return True if legal, false if not
     */
    boolean isLegalMove(Move move);

    /**
     * removes the piece from the board
     */
    void kill();

}
