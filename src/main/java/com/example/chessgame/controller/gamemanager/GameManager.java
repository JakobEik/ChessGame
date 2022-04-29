package com.example.chessgame.controller.gamemanager;

import com.example.chessgame.model.GameState;

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
