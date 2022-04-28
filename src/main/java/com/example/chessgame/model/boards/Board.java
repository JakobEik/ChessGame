package com.example.chessgame.model.boards;


import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.chess_pieces.*;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Square> squares = new ArrayList<>();
    private final List<ChessPiece> pieces = new ArrayList<>();
    private final GameManager gameManager;


    public Board(GameManager gameManager) {
        this.gameManager = gameManager;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                int[] position = new int[]{x, y};
                Square square = new Square(getIndex(x, y), position);
                if (y == 0 || y == 1 || y == 6 || y == 7) {
                    ChessPiece piece = createPiece(square);
                    pieces.add(piece);
                }
                squares.add(square);
            }
        }
    }

    public void emptyBoard() {
        for (Square square : squares) {
            if (square.containsPiece()) {
                square.killChessPiece();
            }
        }
    }


    public List<Square> getSquares() {
        return squares;
    }


    public List<ChessPiece> getPieces() {
        return pieces;
    }

    public Square getSquare(int x, int y) {
        return getSquares().get(getIndex(x, y));
    }

    public boolean containsPiece(int[] position) {
        int x = position[0];
        int y = position[1];
        return squares.get(getIndex(x, y)).containsPiece();
    }

    public boolean containsOpponentPiece(int[] position, boolean isWhite) {
        int x = position[0];
        int y = position[1];
        Square square = squares.get(getIndex(x, y));
        return square.containsPiece() && square.getPiece().isWhite() != isWhite;
    }

    /**
     * A function that moves the piece on the board
     *
     * @param piece the chess piece to be moved
     * @param move  the move to be made
     */
    public void movePiece(ChessPiece piece, Move move) {
        if (piece.isLegalMove(move)) {
            int x = move.getEndPosition()[0];
            int y = move.getEndPosition()[1];

            Square square = getSquare(x, y);
            // Only kill of the square contains a piece of opposite color
            if (square.containsPiece()){
                if (piece.isWhite() != square.getPiece().isWhite()){
                    square.killChessPiece();
                }
            }
            piece.move(square);
        }

    }


    /**
     * Calculates the index from 0-63 from a position
     *
     * @param x The x-position
     * @param y The y-position
     * @return The index
     */
    private int getIndex(int x, int y) {
        return y * 8 + x;
    }

    /**
     * Calculates the position from an index from 0-63
     *
     * @param index The index
     * @return The position as an array
     */
    private int[] getPositionFromIndex(int index) {
        int x = index % 8;
        int y = index / 8;
        return new int[]{x, y};

    }


    /**
     * Creates a piece at the start of the game given a square on the board
     * Used to initialize the board
     *
     * @param square The square on the board
     * @return A chess piece if there's supposed to be a piece on the square, null if not
     */
    private ChessPiece createPiece(Square square) {
        int x = square.getPosition()[0];
        int y = square.getPosition()[1];
        // White pieces 1. row
        if (y == 0) {
            return initPieces(true, square, x);
        }

        // White Pawns
        else if (y == 1) {
            return new Pawn(square, true);
        }

        // Black Pawns
        else if (y == 6) {
            return new Pawn(square, false);
        }

        // Black Pieces
        else if (y == 7) {
            return initPieces(false, square, x);

        }
        // For debugging
        else {
            throw new IllegalArgumentException("y-position need to be 0, 1, 6, or 7 but was: " + y);
        }

    }


    /**
     * Initializes all the other chesspieces given a square
     *
     * @param isWhite Is the piece white
     * @param square  The square
     * @param x       The x-position of the square
     * @return A chesspiece
     * @throws IllegalArgumentException If the x-position is out of bounds
     */
    private ChessPiece initPieces(boolean isWhite, Square square, int x) {
        // Rook
        if (x == 0 || x == 7) {
            return new Rook(square, isWhite);
        }
        // Knight
        else if (x == 1 || x == 6) {
            return new Knight(square, isWhite);
        }
        // Knight
        else if (x == 2 || x == 5) {
            return new Bishop(square, isWhite);
        }
        // Queen
        else if (x == 3) {
            return new Queen(square, isWhite);
        }
        // King
        else if (x == 4) {
            return new King(square, isWhite, gameManager);
        } else {
            throw new IllegalArgumentException("x-position has to be between 0-7 but was" + x);
        }

    }
}
