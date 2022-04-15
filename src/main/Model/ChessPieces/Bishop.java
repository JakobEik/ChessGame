package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;


public class Bishop extends Piece{
    private static final int value = 300;

    public Bishop(Square square, boolean isWhite) {
        super(square, value, isWhite);
    }

    public Bishop(boolean isWhite) {
        super(value, isWhite);
    }




    @Override
    protected void calculateMoves(Square square, Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        addMovesInDirection(x+1, y+1, 1, 1, board);
        addMovesInDirection(x-1, y+1, -1, 1, board);
        addMovesInDirection(x-1, y-1, -1, -1, board);
        addMovesInDirection(x+1, y-1, 1, -1, board);

        /*
        // Move upper right
        int i = 1;
        while(x+i <= 7 && y+i <= 7){
            // Checks if there's a chesspiece at the square
            if (board.containsPiece(x, y)){
                // If the piece is an opponent it is possible to checkMoved to the square and take the piece
                if (board.containsOpponentPiece(x, y, isWhite)){
                    addMove(x+i, y+i);
                }
                // Cant go further since the piece is blocking therefore break from this direction
                break;
            }
            addMove(x+i, y+i);
            i++;
        }

        // Move upper left
        i = 1;
        while (x-i >= 0 && y+i <= 7){
            addMove(x-i, y+i);
            i++;
        }

        // Move lower left
        i = 1;
        while(x-i >= 0 && y-i >= 0){
            addMove(x-i, y-i);
            i++;
        }

        // Move lower right
        i = 1;
        while (x+i <= 7 && y-i >= 0){
            addMove(x+i, y-i);
            i++;
        }*/
    }

    @Override
    protected void checkMoved() {

    }

    /**
     * Helper method for the addMovesInDirection method
     */
    private void addMove(int x, int y){
        Move move = createMove(x, y);
        if (moveIsOnBoard(move)) moves.add(move);
    }




}
