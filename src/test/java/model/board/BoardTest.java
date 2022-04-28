package model.board;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.chess_pieces.Pawn;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(new GameManager());
    }

    @Test
    void emptyBoard() {
        board.emptyBoard();
        List<Square> squares = board.getSquares();
        for (Square square : squares) {
            assertFalse(square.containsPiece());
        }
    }

    @Test
    void getSquare(){
        Square square1 = board.getSquare(7, 7);
        Square square2 = board.getSquare(0, 0);
        Square square3 = board.getSquare(7, 0);
        Square square4 = board.getSquare(4, 1);
        Square square5 = board.getSquare(6, 2);

        assertArrayEquals(new int[]{7, 7}, square1.getPosition());
        assertArrayEquals(new int[]{0, 0}, square2.getPosition());
        assertArrayEquals(new int[]{7, 0}, square3.getPosition());
        assertArrayEquals(new int[]{4, 1}, square4.getPosition());
        assertArrayEquals(new int[]{6, 2}, square5.getPosition());
    }


    @Test
    void movePiece() {
        board.emptyBoard();
        Square square = board.getSquare(1, 1);
        ChessPiece pawn  = new Pawn(square, true);

        Move move = pawn.getMoves(board).iterator().next();
        int x = move.getEndPosition()[0];
        int y = move.getEndPosition()[1];
        Square targetSquare = board.getSquare(x, y);

        board.movePiece(pawn, move);

        System.out.println(targetSquare.toString() +
                " : " + pawn.getSquare().toString());

        assertSame(targetSquare, pawn.getSquare());

    }


    @Test
    void containsPiece() {
        board.emptyBoard();
        assertFalse(board.containsPiece(new int[]{1,1}));

        Square square = board.getSquare(1, 1);
        ChessPiece pawn = new Pawn(square, true);
        assertTrue(board.containsPiece(new int[]{1,1}));
    }

    @Test
    void containsOpponentPiece() {
        board.emptyBoard();
        assertFalse(board.containsOpponentPiece(new int[]{1,1}, true));

        Square square = board.getSquare(1, 1);
        ChessPiece whitePawn = new Pawn(square, true);
        assertFalse(board.containsOpponentPiece(new int[]{1,1}, true));
        assertTrue(board.containsOpponentPiece(new int[]{1,1}, false));

    }
}
