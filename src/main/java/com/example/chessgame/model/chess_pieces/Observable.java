package com.example.chessgame.model.chess_pieces;

import com.example.chessgame.controller.gamemanager.Observer;

public interface Observable {
    //void registerObserver(Observer observer);
    //void removeObserver(Observer observer);
    void notifyObservers();
}
