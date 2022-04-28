package com.example.chessgame.model.chess_pieces;


import com.example.chessgame.controller.gamemanager.GameState;
import com.example.chessgame.controller.gamemanager.Observer;
import com.example.chessgame.model.boards.Board;
import com.example.chessgame.model.square.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece implements Observable{

    private static final int value = 10000000;
    private boolean isFirstMove;
    private List<Observer> observers;

    public King(Square square, boolean isWhite, Observer observer) {
        super(square, value, isWhite);
        isFirstMove = true;
        observers = new ArrayList<>();
        observers.add(observer);
    }

    @Override
    protected void calculateMoves(Board board) {
        // Up
        addMove(0, 1, board);
        // Down
        addMove(0, -1, board);
        // Left
        addMove(-1, 0, board);
        // Right
        addMove(1, 0, board);
        // Cross upper right
        addMove(1, 1, board);
        // Cross upper left
        addMove(-1, 1, board);
        // Cross lower left
        addMove(-1, -1, board);
        // Cross lower right
        addMove(+1, -1, board);

    }



    @Override
    public void die(){

    }



    @Override
    protected void checkMoved() {
        isFirstMove = false;
    }



    @Override
    public void notifyObservers() {
        GameState gameState = isWhite ? GameState.WHITE_WIN : GameState.BLACK_WIN;
        observers.forEach(observer -> observer.update(gameState));
    }
}
