package com.example.chessgame.controller.boards;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.moves.Move;

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

    public void movePiece(String viewID, Move move){
        ChessPiece piece = findCorrectPiece(viewID);
        boardModel.movePiece(piece, move);
        isWhiteTurn = !isWhiteTurn;
    }

    //For testing purposes
    public Board getBoardModel() {
        return boardModel;
    }

    // For testing purposes

    public List<Move> getPieceMoves(String viewID){
        ChessPiece piece = findCorrectPiece(viewID);
        /*
        StringBuilder moves = new StringBuilder(
                "Position: " + Arrays.toString(piece.getSquare().getPosition()) + "\n");
        for (Move move: piece.getMoves(boardModel)) {
            moves.append(move.toString()).append("\n");
        }
        return moves.toString();*/
        return piece.getMoves(boardModel);
    }

    /**
     * Finds the correct piece given an ID from the view
     * @param viewID The view ID. Example: blackRook2
     * @return A ChessPiece
     */
    public ChessPiece findCorrectPiece(String viewID){
        List<ChessPiece> pieces = boardModel.getPieces();

        List<ChessPiece> singlePiece = pieces
                .stream()
                .filter(chessPiece -> getPieceID(chessPiece).equals(viewID))
                .collect(Collectors.toList());

        //Debugging
        if (singlePiece.size() != 1) throw new IllegalArgumentException("Something Wrong");

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
