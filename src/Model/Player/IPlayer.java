package Model.Player;

public interface IPlayer {

    /**
     *
     * @return the total value of this players pieces
     */
    int getValueOfPieces();

    /**
     *
     * @return true if this player has white pieces, false if not
     */
    boolean isWhite();
}
