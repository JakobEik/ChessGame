package main.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.Square.Square;
import main.Model.Moves.Move;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Piece implements ChessPiece {

    protected Square square;
    protected final static Collection<Move> moves = new ArrayList<>();
    protected final boolean isWhite;
    private final int value;


    public Piece(Square square, final int value, boolean isWhite) {
        this.square = square;
        this.value = value;
        this.isWhite = isWhite;
        this.square.addChessPiece(this);
    }

    /**
     * Used for the queen so it can contain a rook and bishop
     */
    public Piece(final int value, boolean isWhite) {
        this.value = value;
        this.isWhite = isWhite;
    }




    @Override
    public Collection<Move> getMoves(Board board) {
        moves.clear();
        calculateMoves(square, board);
        return moves;
    }




    @Override
    public Square getSquare() {
        return square;
    }

    @Override
    public void move(Move move, Board board){
        int x = move.getEndX();
        int y = move.getEndY();

        // Get the square at this location
        this.square = board.getSquares().get(board.getIndex(x, y));
        this.square.addChessPiece(this);
        checkMoved();

    }

    @Override
    public int getValue() {
        return value;
    }


    @Override
    public boolean isWhite() {
        return isWhite;
    }


    @Override
    public void kill() {
        //TODO: Implement method
    }

    /**
     * Calculates the moves for a piece given a square on the board
     * @param square The square
     */
    protected abstract void calculateMoves(Square square, Board board);

    /**
     * Used to tell a concrete piece that it has been moved
     */
    protected abstract void checkMoved();

    /**
     * Simplifies creating a checkMoved by only needing to specify the end position
     * @param endX The target x-position
     * @param endY The target y-position
     * @return A checkMoved from the current position to a target position
     */
    protected Move createMove(int endX, int endY){
        return new Move(endX, endY);
    }

    /**
     * Checks whether a checkMoved goes off the board or not
     * @param move The checkMoved to check
     * @return True if legal checkMoved, false if not
     */
    protected boolean moveIsOnBoard(Move move){
        int x = move.getEndX();
        int y = move.getEndY();
        return x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }

    protected boolean squareContainsPiece(Board board, Move move){
        return board.containsPiece(move.getEndX(), move.getEndY());
    }

    protected boolean squareContainsOpponentPiece(Board board, Move move){
        int x = move.getEndX();
        int y = move.getEndY();
        return board.containsOpponentPiece(x, y, isWhite);
    }



    /**
     * Recursive method for adding moves to the list of possible moves
     * @param x The current x-position on the board
     * @param y The current y-position on the board
     * @param horizontalDir Which way to move in the horizontal direction: Either 1 or -1
     * @param verticalDir Which way to move in the vertical direction: Either 1 or -1
     * @param board The board
     */
    protected void addMovesInDirection(int x, int y, int horizontalDir, int verticalDir, Board board){
        Move move = createMove(x, y);
        if (moveIsOnBoard(move)){
            if (!board.containsPiece(x, y)){
                moves.add(move);
                addMovesInDirection(x+horizontalDir, y+verticalDir, horizontalDir, verticalDir, board);
            }
            else if(squareContainsOpponentPiece(board, move)){
                moves.add(move);
            }
        }

    }

    protected void addMoveIfLegal(Board board, Move move){
        if (moveIsOnBoard(move) && !squareContainsPiece(board, move)){
            moves.add(move);
        }
        else if (moveIsOnBoard(move) && squareContainsOpponentPiece(board, move)){
            moves.add(move);
        }
    }
}
