package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.Knight;
import main.Model.ChessPieces.Pawn;
import main.Model.ChessPieces.Queen;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class QueenTest {

    private Board board;
    private ChessPiece whiteQueen;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.emptyBoard();

        Square square = board.getSquares().get(board.getIndex(1, 1));
        whiteQueen = new Queen(square, true);


    }
    @Test
    void calculateMoves() {
        Square square = board.getSquares().get(board.getIndex(2, 1));
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquares().get(board.getIndex(2, 2));
        ChessPiece whitePawn = new Pawn(square2, true);

        List<int[]> legalMoves = List.of(
                new int[]{2, 1},
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, 2},
                new int[]{2, 0},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{1, 6},
                new int[]{1, 7}
        );

        Collection<Move> moves =  whiteQueen.getMoves(board);


        HelperTestMethods.sameAmountOfMoves(moves, legalMoves);
        HelperTestMethods.containsLegalMoves(moves, legalMoves);



    }
}
