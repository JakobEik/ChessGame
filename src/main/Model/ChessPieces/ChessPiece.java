package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;

import java.util.Collection;

public interface ChessPiece {

    /**
     * @return The value for the piece
     * Use for the AI to check how important a piece is
     */
    int getValue();

    /**
     * @return The square the piece is on
     */
    Square getSquare();

    void moveToSquare(Square square);

    /**
     * Gets all legal moves for this piece on a given board
     * @param board The board
     * @return a list of moves for the piece
     */
    Collection<Move> getMoves(Board board);


    /**
     *
     * @return true if the piece is white, false if the piece is black
     */
    boolean isWhite();

    /**
     * removes the piece from the board
     */
    void kill();

}