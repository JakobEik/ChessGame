package main.Controller.Game;

import main.Controller.Board.Board;
import main.Model.Square.Square;

import java.util.Collection;

public class Game {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        Board board = new Board();
        Collection<Square> squares = board.getSquares();
        for (Square square: squares) {
            if (square.containsPiece()){
                int x = square.getPosition()[0];
                int y = square.getPosition()[1];
                System.out.println(x + "," + y + ": " + square.getPiece().getClass().getSimpleName());

            }
        }


    }
}
