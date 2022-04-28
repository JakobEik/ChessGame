package com.example.chessgame.model.chess_pieces;

import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Piece implements ChessPiece {

    protected Square square;
    protected final static List<Move> moves = new ArrayList<>();
    protected final boolean isWhite;
    private final int value;

    private final int startX;


    public Piece(Square square, final int value, boolean isWhite) {
        this.square = square;
        this.value = value;
        this.isWhite = isWhite;
        this.square.addChessPiece(this);
        startX = square.getPosition()[0];
    }


    public int getStartX(){
        return startX;
    }

    @Override
    public List<Move> getMoves(Board board) {
        moves.clear();
        calculateMoves(board);
        return moves;
    }



    @Override
    public boolean isLegalMove(Move move){
        return moves.contains(move);
    }


    @Override
    public Square getSquare() {
        return square;
    }

    @Override
    public void move(Square square){
        if (validateMoveToSquare(square)){
            this.square.killChessPiece();
            this.square = square;
            square.addChessPiece(this);
            checkMoved();
        }
        else {
            // For debugging only
            throw new IllegalArgumentException("Illegal move: " + Arrays.toString(square.getPosition()));
        }

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
    public void die() {
        square = null;
    }

    /**
     * Calculates the moves for a piece on a given board
     * @param board The board
     */
    protected abstract void calculateMoves(Board board);

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
        int x = move.getEndPosition()[0];
        int y = move.getEndPosition()[1];
        return x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }

    protected boolean squareContainsPiece(Board board, Move move){
        return board.containsPiece(move.getEndPosition());
    }

    protected boolean squareContainsOpponentPiece(Board board, Move move){
        return board.containsOpponentPiece(move.getEndPosition(), isWhite);
    }



    /**
     * Recursive method for adding moves to the list of possible moves
     * @param x The current x-position on the board
     * @param y The current y-position on the board
     * @param x_dir Which way to move in the horizontal direction: Either 1 or -1
     * @param y_dir Which way to move in the vertical direction: Either 1 or -1
     * @param board The board
     */
    protected void addMovesInDirection(int x, int y, int x_dir, int y_dir, Board board){
        Move move = createMove(x, y);
        if (moveIsOnBoard(move)){
            if (!board.containsPiece(move.getEndPosition())){
                moves.add(move);
                addMovesInDirection(x+x_dir, y+y_dir, x_dir, y_dir, board);
            }
            else if(squareContainsOpponentPiece(board, move)){
                moves.add(move);
            }
        }

    }

    /**
     * Creates and adds a move to the list of moves for this piece if the move is a valid one
     * @param x_dir The move in the x-direction
     * @param y_dir The move in the y-direction
     * @param board The Board
     */
    protected void addMove(int x_dir, int y_dir, Board board){
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];
        Move move = createMove(x+x_dir, y+y_dir);
        addMoveIfLegal(board, move);
    }

    /**
     * Checks if a move is legal for this piece
     * @param board The Board
     * @param move The move
     */
    protected void addMoveIfLegal(Board board, Move move){
        if (moveIsOnBoard(move) && !squareContainsPiece(board, move)){
            moves.add(move);
        }
        else if (moveIsOnBoard(move) && squareContainsOpponentPiece(board, move)){
            moves.add(move);
        }
    }

    private boolean validateMoveToSquare(Square square){
        return moves
                .stream()
                .anyMatch(move -> Arrays.equals(move.getEndPosition(), square.getPosition()));
    }

}
