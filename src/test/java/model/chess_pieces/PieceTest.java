package model.chess_pieces;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.*;
import com.example.chessgame.model.square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private final Board board = new Board(new GameManager());
    private ChessPiece pawn;
    Square square;

    @BeforeEach
    void setUp() {
        board.emptyBoard();

        square = board.getSquare(2, 3);
        pawn = new Pawn(square, true);


    }



    @Test
    void getSquare() {
        assertEquals(square, pawn.getSquare());
    }

    @Test
    void wrongMove() {
        Square square = board.getSquare(3, 4);
        Exception e = assertThrows(IllegalArgumentException.class, () -> pawn.move(square));
        assertNotEquals(square, pawn.getSquare());


    }

    @Test
    void rightMove(){
        Square square = board.getSquare(2, 4);
        pawn.move(square);
        assertEquals(square, pawn.getSquare());
    }



}
