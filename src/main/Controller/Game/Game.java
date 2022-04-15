package main.Controller.Game;

import main.Controller.Board.Board;
import main.Model.ChessPieces.Bishop;
import main.Model.ChessPieces.ChessPiece;
import main.Model.ChessPieces.Piece;
import main.Model.Square.Square;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        Board board = new Board();
        board.emptyBoard();
        Collection<Square> squares = board.getSquares();
        for (Square square: squares) {
            if (square.containsPiece()){
                int x = square.getPosition()[0];
                int y = square.getPosition()[1];
                System.out.println(x + "," + y + ": " + square.getPiece().getClass().getSimpleName());

            }
        }

        List<int[]> legalMovesWhitePawn = List.of(
                new int[]{1, 2}, // One forward
                new int[]{1, 3}  // Two forward
        );

        int[] a = new int[]{1, 2};

        boolean test =  legalMovesWhitePawn.
                stream().anyMatch(move -> Arrays.equals(move, a));


        System.out.println(test);


    }
}
