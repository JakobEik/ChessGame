package test.Model.ChessPieces;

import main.Model.Moves.Move;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HelperMethods {

    public static void containsOnlyLegalMoves(Collection<Move> moves, List<int[]> legalMoves){

         assertEquals(legalMoves.size(), moves.size());


        for (Move move: moves) {
            int[] pieceMoves = new int[]{move.getEndX(), move.getEndY()};
            assertTrue(legalMoves.
                    stream().anyMatch(testMove -> Arrays.equals(testMove, pieceMoves)));


        }
    }
}
