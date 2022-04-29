package com.example.chessgame.controller.gamemanager;

import com.example.chessgame.model.GameState;

public interface Observer {
    void update(GameState newState);
}
