package com.example.chessgame.controller.gamemanager;

import com.example.chessgame.controller.fileHandler.ChessFileHandler;
import com.example.chessgame.controller.fileHandler.FileHandler;

public class GameManager implements Observer{

    private GameState gameState;

    public GameManager() {
        gameState = GameState.ACTIVE;
    }

    @Override
    public void update(GameState newState) {
        gameState = newState;

    }

    public GameState getGameState() {
        return gameState;
    }

}
