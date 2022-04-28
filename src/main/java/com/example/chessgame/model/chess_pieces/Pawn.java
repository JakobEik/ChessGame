package com.example.chessgame.model.chess_pieces;


import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;

public class Pawn extends Piece {
    private static final int value = 100;
    private boolean isFirstMove;


    public Pawn(Square square, boolean isWhite) {
        super(square, value, isWhite);
        isFirstMove = true;
    }





    @Override
    protected void calculateMoves(Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];
        int direction = !isWhite() ? -1 : 1; // Black is on top => checkMoved down (-1 direction)
        if (isFirstMove){
            moves.add( createMove(x, y + 2 * direction));
        }
        Move forward = createMove(x, y+direction);
        Move crossLeft = createMove(x-1, y+direction);
        Move crossRight = createMove(x+1, y+direction);

        // Only add to list if in range of the board and if there's no piece in front
        if (moveIsOnBoard(forward) && !squareContainsPiece(board, forward)){
            moves.add(forward);
        }
        if (moveIsOnBoard(crossLeft) && squareContainsOpponentPiece(board, crossLeft)){
            moves.add(crossLeft);
        }
        if (moveIsOnBoard(crossRight) && squareContainsOpponentPiece(board, crossRight)){
            moves.add(crossRight);
        }



    }

    @Override
    protected void checkMoved() {
        isFirstMove = false;
    }





}
