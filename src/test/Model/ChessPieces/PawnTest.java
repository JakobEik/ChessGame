package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.Pawn;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.emptyBoard();


    }

    @Test
    void testFirstMove() {
        Square square = board.getSquares().get(board.getIndex(1, 1));
        Pawn whitePawn = new Pawn(square, true);

        List<int[]> legalMovesWhitePawn = List.of(
                new int[]{1, 2}, // One forward
                new int[]{1, 3}  // Two forward
        );

        Collection<Move> moves =  whitePawn.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhitePawn);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhitePawn);
    }

    @Test
    void testSecondMove(){
        Move move = new Move(5, 0, 5, 1);
        Square square = board.getSquares().get(board.getIndex(5, 0));
        Pawn pawn = new Pawn(square, true);
        pawn.move(move, board);

        Collection<Move> moves =  pawn.getMoves(board);

        assertEquals(1, moves.size());

        Move testMove = moves.iterator().next();
        assertEquals(testMove.getEndX(), 5);
        assertEquals(testMove.getEndY(), 2);
    }
}


