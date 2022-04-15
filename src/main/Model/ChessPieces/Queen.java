package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;

/**
 * Queen is just a rook and bishop put together
 */
public class Queen extends Piece{
    private static final int value = 900;
    private final Piece rook;
    private final Piece bishop;

    public Queen(Square square, boolean isWhite) {
        super(square, value, isWhite);
        rook = new Rook(isWhite);
        square.removeChessPiece();
        bishop = new Bishop(isWhite);

    }

    @Override
    protected void calculateMoves(Square square, Board board) {
        rook.calculateMoves(square, board);
        bishop.calculateMoves(square, board);
        moves.addAll(rook.getMoves(board));
        moves.addAll(bishop.getMoves(board));


    }

    @Override
    protected void checkMoved() {
        //Does nothing
    }


}
