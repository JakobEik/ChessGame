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
        //Does nothing
    }


}
