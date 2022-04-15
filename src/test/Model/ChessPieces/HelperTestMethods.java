package test.Model.ChessPieces;

import main.Model.Moves.Move;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HelperTestMethods {

    public static void containsLegalMoves(Collection<Move> moves, List<int[]> legalMoves){

        for (Move move: moves) {
            int[] pieceMove = new int[]{move.getEndX(), move.getEndY()};
            assertTrue(legalMoves.
                    stream()
                    .anyMatch(legalMove -> Arrays.equals(legalMove, pieceMove)),
                    "Illegal move:" + pieceMove[0] + "," + pieceMove[1]);


        }
    }

    public static void sameAmountOfMoves(Collection<Move> moves, List<int[]> legalMoves){
        assertEquals(legalMoves.size(), moves.size());
    }
}
