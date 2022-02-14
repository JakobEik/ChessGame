package Model.Board;

import Model.ChessPieces.IChessPiece;
import Model.HelperClasses.Position;
import Model.Moves.IMove;

import java.util.Collection;

public interface IBoard {

    /**
     *
     * @param piece the chess piece to be moved
     * @param position the square to move the piece to
     */
    void movePiece(IChessPiece piece, Position position);

    /**
     *
     * @param piece the chess piece to be moved
     * @return a collection of possible moves
     */
    Collection<IMove> getPossibleMoves(IChessPiece piece);
}
