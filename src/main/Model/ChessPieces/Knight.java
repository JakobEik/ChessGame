package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;

public class Knight extends Piece{
    private static final int value = 300;
    public Knight(Square square, boolean isWhite) {
        super(square, value, isWhite);
    }

    @Override
    protected void calculateMoves(Square square, Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        Move oneUpTwoRight = createMove(x+2, y+1);
        if (isLegalMove(oneUpTwoRight)) moves.add(oneUpTwoRight);

        Move twoUpOneRight = createMove(x+1, y+2);
        if (isLegalMove(twoUpOneRight)) moves.add(twoUpOneRight);

        Move twoUpOneLeft = createMove(x-1, y+2);
        if (isLegalMove(twoUpOneLeft)) moves.add(twoUpOneLeft);

        Move oneUpTwoLeft = createMove(x-2, y+1);
        if (isLegalMove(oneUpTwoLeft)) moves.add(oneUpTwoLeft);

        Move oneDownTwoRight = createMove(x+2, y-1);
        if (isLegalMove(oneDownTwoRight)) moves.add(oneDownTwoRight);

        Move twoDownOneRight = createMove(x+1, y-2);
        if (isLegalMove(twoDownOneRight)) moves.add(twoDownOneRight);

        Move twoDownOneLeft = createMove(x-1, y-2);
        if (isLegalMove(twoDownOneLeft)) moves.add(twoDownOneLeft);

        Move oneDownTwoLeft = createMove(x-2, y-1);
        if (isLegalMove(oneDownTwoLeft)) moves.add(oneDownTwoLeft);





    }

    @Override
    protected void move() {

    }


}