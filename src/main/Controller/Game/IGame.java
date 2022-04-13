package main.Controller.Game;

import main.Model.Player.IPlayer;

import java.util.List;

public interface IGame {

    /**
     *
     * @return the status of the game
     */
    GameStatus getGameStatus();

    /**
     * set the status of the game
     */
    void setGameStatus(GameStatus status);

    /**
     *
     * @return the current board of the game
     */
    Board getBoard();


    /**
     *
     * @return the players in the game
     */
    List<IPlayer> getPLayers();
}
