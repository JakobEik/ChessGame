package com.example.chessgame.controller.boards;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.moves.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardController {
    private final Board boardModel;
    private boolean isWhiteTurn;
    public BoardController(GameManager gameManager) {
        boardModel = new Board(gameManager);
        isWhiteTurn = true;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    /**
     * Moves a piece in the model given a viewID from the view
     * @param viewID The piece ID
     * @param move The move to be made
     * @return True if the move was made, false if not
     */
    public boolean movePiece(String viewID, Move move){
        try {
            ChessPiece piece = findCorrectPiece(viewID);
            boolean moveSuccess = boardModel.movePiece(piece, move);
            isWhiteTurn = !isWhiteTurn;
            return moveSuccess;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }


    }

    //For testing purposes
    public Board getBoardModel() {
        return boardModel;
    }

    /**
     * Returns a list of moves of the piece that matches the viewID
     * @param viewID A string of the ID for an object in the view
     * @return The list of possible moves
     */
    public List<Move> getPieceMoves(String viewID){
        try {
            ChessPiece piece = findCorrectPiece(viewID);
            return piece.getMoves(boardModel);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Finds the correct piece given an ID from the view
     * @param viewID The view ID. Example: blackRook2
     * @return A ChessPiece
     */
    public ChessPiece findCorrectPiece(String viewID) throws IllegalArgumentException{
        List<ChessPiece> pieces = boardModel.getPieces();

        List<ChessPiece> singlePiece = pieces
                .stream()
                .filter(chessPiece -> getPieceID(chessPiece).equals(viewID))
                .collect(Collectors.toList());

        //Debugging
        if (singlePiece.size() != 1){
            throw new IllegalArgumentException("There should only be one piece that matches the viewID");
        }

        return singlePiece.iterator().next();
    }



    /**
     * Public for testing purposes
     * Creates a NameID for the piece.
     * @return A String with the NameID of this piece. Example: blackpawn1
     */
    public String getPieceID(ChessPiece piece){

        String color = piece.isWhite() ? "white" : "black";
        String pieceName = piece.getClass().getSimpleName();
        int x = piece.getStartX();

        final String ID_number;
        if (!pieceName.equals("Pawn")){
            if (x < 3){
                ID_number = "1";
            }
            // Queen and King doesnt need ID number
            else if (x == 3 || x == 4) {
                ID_number = "";
            }
            else {
                ID_number = "2";
            }
        }
        // Pawn
        else {
            ID_number = String.valueOf(x + 1); // + 1 to start from 1 instead of 0
        }

        return color + pieceName + ID_number;
    }






}
