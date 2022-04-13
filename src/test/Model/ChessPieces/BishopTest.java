package test.Model.ChessPieces;


import junit.framework.TestCase;
import main.Controller.Board.Board;
import main.Model.ChessPieces.Bishop;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.Piece;
import main.Model.Moves.Move;
import main.Model.Square.Square;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RunWith(JUnit4.class)
class BishopTest extends TestCase {

    private Board board;
    private Piece whiteBishop;
    private ChessPiece blackPawn;
    private ChessPiece whitePawn;



    protected void setUp() throws Exception {
        super.setUp();
        board = new Board();
        board.emptyBoard();

        Square square1 = board.getSquares().get(board.getIndex(1, 1));
        whiteBishop = new Bishop(square1, true);
        square1.addChessPiece(whiteBishop);

        Square square2 = board.getSquares().get(board.getIndex(5, 5));
        blackPawn = new Bishop(square2, true);
        square1.addChessPiece(blackPawn);

        Square square3 = board.getSquares().get(board.getIndex(0, 2));
        whitePawn = new Bishop(square3, true);
        square1.addChessPiece(whitePawn);
    }

    public void testGetMoves(){
        Collection<Move> moves =  whiteBishop.getMoves(board);
        List<int[]> legalMovesWhiteBishop = List.of(
                new int[]{0, 0},
                new int[]{1, 0},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{4, 4},
                new int[]{5, 5} // can take black pawn
        );

        assertEquals(legalMovesWhiteBishop.size(), moves.size());

        for (Move move: moves) {
            int[] testMove = new int[]{move.getEndX(), move.getEndY()};
            assertTrue(legalMovesWhiteBishop.contains(testMove));
        }



    }




}
