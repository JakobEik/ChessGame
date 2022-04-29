package model.chess_pieces;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.chess_pieces.pieces.Pawn;
import com.example.chessgame.model.chess_pieces.pieces.Rook;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class RookTest {

    private Board board;
    private ChessPiece whiteRook;

    @BeforeEach
    void setUp() {
        board = new Board(new GameManager());
        board.emptyBoard();

        Square square = board.getSquare(2, 1);
        whiteRook = new Rook(square, true);



    }

    @Test
    void calculateMoves() {
        Square square = board.getSquare(1, 1);
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquare(3, 1);
        ChessPiece whitePawn = new Pawn(square2, true);
        String s = "";

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
