package Model.ChessPieces;

import javax.swing.text.Position;
import java.util.List;
import java.util.Vector;

public interface IChessPiece {

    /**
     *
     * @return the value of the piece
     */
    int getValue();


    /**
     *
     * @return the x-position of the piece
     */
    int getX();

    /**
     *
     * @return the y-position of the piece
     */
    int getY();

    /**
     *
     * @param x the x-position of the piece
     * @param y the y-position of the piece
     */
    void setPosition(int x, int y);

    /**
     *
     * @return a list of vectors containing the possible moves for the piece
     */
    List<Vector<Integer>> getPossibleMoves();


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
