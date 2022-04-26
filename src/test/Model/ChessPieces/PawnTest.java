package test.Model.ChessPieces;

import main.Controller.Board.Board;
import main.Model.ChessPieces.ChessPiece;
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
        Square square = board.getSquare(1, 1);
        ChessPiece whitePawn = new Pawn(square, true);

        List<int[]> legalMovesWhitePawn = List.of(
                new int[]{1, 2}, // One forward
                new int[]{1, 3}  // Two forward
        );

        Collection<Move> moves =  whitePawn.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhitePawn);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhitePawn);

        Square square1 = board.getSquare(2, 2);
        ChessPiece blackPawn1 = new Pawn(square1, false);

        Square square2 = board.getSquare(0, 2);
        ChessPiece blackPawn2 = new Pawn(square2, false);

        legalMovesWhitePawn = List.of(
                new int[]{1, 2},  // One forward
                new int[]{1, 3},  // Two forward
                new int[]{0, 2},  // Take black pawn
                new int[]{2, 2}   // Take black pawn
        );

        moves =  whitePawn.getMoves(board);
        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhitePawn);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhitePawn);

    }

    @Test
    void testSecondMove(){
        Square square = board.getSquare(1, 0);
        ChessPiece whitePawn = new Pawn(square, true);
        Square targetSquare = board.getSquare(1,1);
        whitePawn.move(targetSquare);

        Collection<Move> moves =  whitePawn.getMoves(board);

        assertEquals(1, moves.size());

        Move testMove = moves.iterator().next();


        assertEquals(1, testMove.getEndPosition()[0]);
        assertEquals(2, testMove.getEndPosition()[1]);

        Square square1 = board.getSquare(2, 2);
        ChessPiece blackPawn1 = new Pawn(square1, false);

        Square square2 = board.getSquare(0, 2);
        ChessPiece blackPawn2 = new Pawn(square2, false);

        List<int[]> legalMovesWhitePawn = List.of(
                new int[]{1, 2},  // One forward
                new int[]{0, 2},  // Take black pawn
                new int[]{2, 2}   // Take black pawn
        );

        moves =  whitePawn.getMoves(board);
        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhitePawn);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhitePawn);

    }
}


