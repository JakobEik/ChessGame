package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.King;
import main.Model.ChessPieces.Pawn;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class KingTest {

    private Board board;
    private ChessPiece whiteKing;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.emptyBoard();

        Square square = board.getSquare(1, 1);
        whiteKing = new King(square, true);



    }

    @Test
    void calculateMoves() {
        Square square = board.getSquare(2, 2);
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquare(1, 2);
        ChessPiece whitePawn = new Pawn(square2, true);

        List<int[]> legalMovesWhiteKing = List.of(
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{2, 2},
                new int[]{2, 1},
                new int[]{2, 0}
        );

        Collection<Move> moves =  whiteKing.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhiteKing);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhiteKing);


    }
}
