package Model.ChessPieces;

import Model.HelperClasses.Position;
import Model.Moves.IMove;

import java.util.Collection;
import java.util.Vector;

public interface IChessPiece {

    /**
     *
     * @return the value of the piece
     */
    int getValue();


    /**
     *
     * @return the position of the piece
     */
    Position getPosition();


    /**
     *
     * @param position the new position of the piece
     */
    void setPosition(Position position);

    /**
     *
     * @return a list of moves for the piece
     */
    Collection<IMove> getMoves();


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
