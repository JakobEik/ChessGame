package model.chess_pieces;

import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.chess_pieces.Bishop;
import com.example.chessgame.model.chess_pieces.ChessPiece;
import com.example.chessgame.model.chess_pieces.Pawn;
import com.example.chessgame.model.chess_pieces.Piece;
import com.example.chessgame.model.moves.Move;
import com.example.chessgame.model.square.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class BishopTest {
    private Board board;
    private Piece whiteBishop;

    @BeforeEach
    void setUp() {
        board = new Board(new GameManager());
        board.emptyBoard();


        Square square1 = board.getSquare(1, 1);
        whiteBishop = new Bishop(square1, true);


    }

    @Test
    void calculateMoves() {
        Square square2 = board.getSquare(5, 5);
        ChessPiece blackPawn = new Pawn(square2, false);



        Square square3 = board.getSquare(0, 2);
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


        HelperTestMethods.sameAmountOfMoves(moves, legalMovesWhiteBishop);

        HelperTestMethods.containsLegalMoves(moves, legalMovesWhiteBishop);

    }
}
