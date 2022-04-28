package model.chess_pieces;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.chess_pieces.King;
import com.example.chessgame.model.chess_pieces.Pawn;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class KingTest {

    private Board board;
    private ChessPiece whiteKing;

    @BeforeEach
    void setUp() {
        GameManager gameManager = new GameManager();
        board = new Board(gameManager);
        board.emptyBoard();

        Square square = board.getSquare(1, 1);
        whiteKing = new King(square, true, gameManager);



    }

    @Test
    void calculateMoves() {
        Square square = board.getSquare(2, 2);
        ChessPiece blackPawn = new Pawn(square, false);

        Square square2 = board.getSquare(1, 2);
        ChessPiece whitePawn = new Pawn(square2, true);

        List<int[]> legalMovesWhiteKing = List.of(
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{2, 2},
                new int[]{2, 1},
                new int[]{2, 0}
        );

        Collection<Move> moves =  whiteKing.getMoves(board);

        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhiteKing);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhiteKing);

        whiteKing.move(board.getSquare(1, 0));
        moves =  whiteKing.getMoves(board);
        legalMovesWhiteKing = List.of(
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 1},
                new int[]{2, 1},
                new int[]{2, 0}
        );

        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhiteKing);
        HelperTestMethods.containsLegalMoves(moves, legalMovesWhiteKing);




    }
}
