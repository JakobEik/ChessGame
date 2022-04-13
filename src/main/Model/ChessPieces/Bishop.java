package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;


public class Bishop extends Piece{
    private static final int value = 300;

    public Bishop(Square square, boolean isWhite) {
        super(square, value, isWhite);
    }



    @Override
    protected void calculateMoves(Square square, Board board) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];

        addMoves(x, y, 1, 1, board);
        addMoves(x, y, -1, 1, board);
        addMoves(x, y, -1, -1, board);
        addMoves(x, y, 1, -1, board);
        /*
        // Move upper right
        int i = 1;
        while(x+i <= 7 && y+i <= 7){
            // Checks if there's a chesspiece at the square
            if (board.containsPiece(x, y)){
                // If the piece is an opponent it is possible to move to the square and take the piece
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
    protected void move() {

    }

    /**
     * Helper method for the addMoves method
     */
    private void addMove(int x, int y){
        Move move = createMove(x, y);
        if (isLegalMove(move)) moves.add(move);
    }

    /**
     * Recursive method for adding moves to the list of possible moves
     * @param x The current x-position on the board
     * @param y The current y-position on the board
     * @param horizontalDir Which way to move in the horizontal direction: Either 1 or -1
     * @param verticalDir Which way to move in the vertical direction: Either 1 or -1
     * @param board The board
     */
    private void addMoves(int x, int y, int horizontalDir, int verticalDir, Board board){
        // If the square is on the edge => Add move to this square and return void
        if (x == 0 || x == 7 || y == 0 || y == 7){
            addMove(x, y);
        }
        // Checks if there's a chesspiece at the current square
        else if (board.containsPiece(x, y)){
            // If the piece is an opponent it is possible to move to the square and take the piece
            if (board.containsOpponentPiece(x, y, isWhite)){
                addMove(x, y);
            }
            // If it's not the opponent, the piece cant move there since it is on the same team
            // Cant go further since the piece is blocking the way => return void
        }
        else{
            // No edge case => add square to move and continue the recursive method
            addMove(x, y);
            addMoves(x+horizontalDir, y+verticalDir, horizontalDir, verticalDir, board);
        }
    }


}
