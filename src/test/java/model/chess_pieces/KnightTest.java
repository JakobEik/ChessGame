package model.chess_pieces;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.chess_pieces.Knight;
import com.example.chessgame.model.chess_pieces.Pawn;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class KnightTest {

    private Board board;
    private ChessPiece whiteKnight;

    @BeforeEach
    void setUp() {
        board = new Board(new GameManager());
        board.emptyBoard();

        Square square = board.getSquare(2, 1);
        whiteKnight = new Knight(square, true);



    }


    @Test
    void calculateMoves() {
        Square square = board.getSquare(0, 0);
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquare(4, 0);
        ChessPiece whitePawn = new Pawn(square2, true);

        List<int[]> legalMoves = List.of(
                new int[]{0, 0},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{3, 3},
                new int[]{4, 2}

        );

        Collection<Move> moves =  whiteKnight.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMoves);
        HelperTestMethods.containsLegalMoves(moves, legalMoves);

    }
}
