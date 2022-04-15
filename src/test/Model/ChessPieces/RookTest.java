package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.Pawn;
import main.Model.ChessPieces.Rook;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class RookTest {

    private Board board;
    private ChessPiece whiteRook;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.emptyBoard();

        Square square = board.getSquares().get(board.getIndex(2, 1));
        whiteRook = new Rook(square, true);



    }

    @Test
    void calculateMoves() {
        Square square = board.getSquares().get(board.getIndex(1, 1));
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquares().get(board.getIndex(3, 1));
        ChessPiece whitePawn = new Pawn(square2, true);

        List<int[]> legalMoves = List.of(
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{2, 2},
                new int[]{2, 3},
                new int[]{2, 4},
                new int[]{2, 5},
                new int[]{2, 6},
                new int[]{2, 7}
        );

        Collection<Move> moves = whiteRook.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMoves);
        HelperTestMethods.containsLegalMoves(moves, legalMoves);


    }
}
