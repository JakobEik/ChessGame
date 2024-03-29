package model.chess_pieces;


import com.example.chessgame.model.moves.Move;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HelperTestMethods {

    public static void containsLegalMoves(Collection<Move> moves, List<int[]> legalMoves){

        for (Move move: moves) {
            int[] pieceMove = new int[]{move.getEndPosition()[0], move.getEndPosition()[1]};
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
