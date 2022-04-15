package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;


public class King extends Piece{

    private static final int value = 10000000;
    private boolean isFirstMove;

    public King(Square square, boolean isWhite) {
        super(square, value, isWhite);
        isFirstMove = true;
    }

    @Override
    protected void calculateMoves(Square square, Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];
        Move up = createMove(x, y+1);
        addMoveIfLegal(board, up);

        Move down = createMove(x, y-1);
        addMoveIfLegal(board, down);

        Move left = createMove(x-1, y);
        addMoveIfLegal(board, left);

        Move right = createMove(x+1, y);
        addMoveIfLegal(board, right);

        Move crossUpperRight = createMove(x+1, y+1);
        addMoveIfLegal(board, crossUpperRight);

        Move crossUpperLeft = createMove(x-1, y+1);
        addMoveIfLegal(board, crossUpperLeft);

        Move crossLowerLeft = createMove(x-1, y-1);
        addMoveIfLegal(board, crossLowerLeft);

        Move crossLowerRight = createMove(x+1, y-1);
        addMoveIfLegal(board, crossLowerRight);

    }





    @Override
    protected void checkMoved() {
        isFirstMove = false;
    }


}
