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
    public void moveToSquare(Square square){
        this.square = square;
        square.addChessPiece(this);
        move();

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
    protected abstract void move();

    /**
     * Simplifies creating a move by only needing to specify the end position
     * @param endX The target x-position
     * @param endY The target y-position
     * @return A move from the current position to a target position
     */
    protected Move createMove(int endX, int endY){
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];
        return new Move(x, y, endX, endY);
    }

    /**
     * Checks whether a move goes off the board or not
     * @param move The move to check
     * @return True if legal move, false if not
     */
    protected boolean isLegalMove(Move move){
        int x = move.getEndX();
        int y = move.getEndY();
        return x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }
}
