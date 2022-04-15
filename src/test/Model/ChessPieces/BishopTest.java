package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.Bishop;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.Pawn;
import main.Model.ChessPieces.Piece;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private Board board;
    private Piece whiteBishop;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.emptyBoard();


        Square square1 = board.getSquares().get(board.getIndex(1, 1));
        whiteBishop = new Bishop(square1, true);


    }

    @Test
    void calculateMoves() {
        Square square2 = board.getSquares().get(board.getIndex(5, 5));
        ChessPiece blackPawn = new Pawn(square2, false);

        Square square3 = board.getSquares().get(board.getIndex(0, 2));
        ChessPiece whitePawn = new Pawn(square3, true);

        Collection<Move> moves =  whiteBishop.getMoves(board);
        List<int[]> legalMovesWhiteBishop = List.of(
                new int[]{0, 0},
                new int[]{2, 0},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{4, 4},
                new int[]{5, 5} // can take black pawn
        );

        for (Move move: moves) {
            System.out.println(move.getEndX() + "," + move.getEndY());
        }

        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhiteBishop);

        HelperTestMethods.containsLegalMoves(moves, legalMovesWhiteBishop);

    }
}


