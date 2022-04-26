package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.Pawn;
import main.Model.ChessPieces.Piece;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private Board board = new Board();
    private Piece pawn;
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
    void move() {
        Square square = board.getSquare(3, 4);
        pawn.move(square);
        assertEquals(square, pawn.getSquare());

    }



}
