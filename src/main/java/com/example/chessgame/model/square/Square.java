package com.example.chessgame.model.square;

import com.example.chessgame.model.chess_pieces.ChessPiece;

import java.util.Arrays;

public class Square {

    private final int ID;
    private final int[] position;
    private boolean containsPiece = false;
    private ChessPiece piece;


    public Square(int ID, int[] position) {
        this.ID = ID;
        this.position = position;


    }

    public int getID() {
        return ID;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    /**
     *
     * @return the position of the square
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * @return True if the square is occupied by a piece, false if not
     */
    public boolean containsPiece() {
        return containsPiece;
    }

    public void addChessPiece(ChessPiece piece){
        if(containsPiece){
            throw new IllegalStateException("Square is occupied");
        }

        this.piece = piece;
        containsPiece = true; // The square is now occupied
    }

    public void killChessPiece(){
        if (piece != null){
            piece.die();
            containsPiece = false; // Square is no longer occupied
            piece = null; // The square no longer contains a piece
        }
    }


    @Override
    public String toString() {
        return "Square{" +
                "position=" + Arrays.toString(position) +
                '}';
    }
}
