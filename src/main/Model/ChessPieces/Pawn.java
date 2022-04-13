package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;


public class Pawn extends Piece {
    private static final int value = 100;
    private boolean isFirstMove;


    public Pawn(Square square, boolean isWhite) {
        super(square, value, isWhite);
        isFirstMove = true;
    }





    @Override
    protected void calculateMoves(Square square, Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];
        int direction = !isWhite() ? -1 : 1; // Black is on top => move down (-1 direction)
        if (isFirstMove){
            moves.add( createMove(x, y + 2 * direction));
        }
        Move forward = createMove(x, y+direction);
        Move crossLeft = createMove(x-1, y+direction);
        Move crossRight = createMove(x+1, y+direction);

        // Only add to list if in range of the board and if there's no piece in front
        if (isLegalMove(forward) && !squareContainsPiece(board, forward)){
            moves.add(forward);
        }
        if (isLegalMove(crossLeft) && squareContainsOpponentPiece(board, crossLeft)){
            moves.add(crossLeft);
        }
        if (isLegalMove(crossRight) && squareContainsOpponentPiece(board, crossRight)){
            moves.add(crossRight);
        }



    }

    @Override
    protected void move() {
        isFirstMove = false;
    }

    private boolean squareContainsPiece(Board board, Move move){
        return board.containsPiece(move.getEndX(), move.getEndY());
    }

    private boolean squareContainsOpponentPiece(Board board, Move move){
        int x = move.getEndX();
        int y = move.getEndY();
        return board.containsOpponentPiece(x, y, isWhite);
    }



}
