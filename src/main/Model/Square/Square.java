package main.Model.Square;

import main.Model.ChessPieces.ChessPiece;

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

    public ChessPiece removeChessPiece(){
        if (piece == null){
            throw new IllegalStateException("Cant remove piece from a square without a piece");
        }
        containsPiece = false; // Square is no longer occupied
        ChessPiece chessPiece = piece; // Copies the piece so it can be set to null
        piece = null; // The square no longer contains a piece
        return chessPiece;

    }







}
