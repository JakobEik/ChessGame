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
        if (isLegalMove(up)) moves.add(up);

        Move down = createMove(x, y-1);
        if (isLegalMove(down)) moves.add(down);

        Move left = createMove(x-1, y);
        if (isLegalMove(left)) moves.add(left);

        Move right = createMove(x+1, y);
        if (isLegalMove(right)) moves.add(right);

    }

    @Override
    protected void move() {
        isFirstMove = false;
    }


}
