package controller;

import com.example.chessgame.controller.boards.BoardController;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardControllerTest {
    private BoardController boardController;
    private Board board;
    ChessPiece whitePawn1;
    ChessPiece blackQueen;
    ChessPiece whiteBishop1;
    ChessPiece blackBishop2;


    @BeforeEach
    void setUp(){
        boardController = new BoardController(null);
        board = boardController.getBoardModel();
        whitePawn1 = board.getSquare(0, 1).getPiece();
        blackQueen = board.getSquare(3, 7).getPiece();
        whiteBishop1 = board.getSquare(2, 0).getPiece();
        blackBishop2 = board.getSquare(5, 7).getPiece();
    }

    @Test
    void getPieceID() {
        assertEquals("whitePawn1", boardController.getPieceID(whitePawn1));
        assertEquals("blackQueen", boardController.getPieceID(blackQueen));
        assertEquals("whiteBishop1", boardController.getPieceID(whiteBishop1));
        assertEquals("blackBishop2", boardController.getPieceID(blackBishop2));
    }

    @Test
    void findCorrectPiece(){
        assertSame(whitePawn1, boardController.findCorrectPiece("whitePawn1"));
        assertSame(blackQueen, boardController.findCorrectPiece("blackQueen"));
        assertSame(whiteBishop1, boardController.findCorrectPiece("whiteBishop1"));
        assertSame(blackBishop2, boardController.findCorrectPiece("blackBishop2"));

        System.out.println(boardController.getPieceMoves("whitePawn1"));
    }
}
