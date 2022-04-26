package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.Knight;
import main.Model.ChessPieces.Pawn;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class KnightTest {

    private Board board;
    private ChessPiece whiteKnight;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.emptyBoard();

        Square square = board.getSquare(2, 1);
        whiteKnight = new Knight(square, true);



    }


    @Test
    void calculateMoves() {
        Square square = board.getSquare(0, 0);
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquare(4, 0);
        ChessPiece whitePawn = new Pawn(square2, true);

        List<int[]> legalMoves = List.of(
                new int[]{0, 0},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{3, 3},
                new int[]{4, 2}

        );

        Collection<Move> moves =  whiteKnight.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMoves);
        HelperTestMethods.containsLegalMoves(moves, legalMoves);

    }
}
