package Model.ChessPieces;

import Model.HelperClasses.Position;

import java.util.List;
import java.util.Vector;

public abstract class ChessPiece implements IChessPiece{

    private Position position;
    private final int value;
    private final boolean isWhite;

    public ChessPiece(Position position, final int value, boolean isWhite) {
        this.position = position;
        this.value = value;
        this.isWhite = isWhite;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Position getPosition() {
        return position;
    }



    @Override
    public void setPosition(Position position) {
        this.position = position;
    }



    @Override
    public boolean isWhite() {
        return isWhite;
    }


    @Override
    public void kill() {
        //TODO: Implement method
    }
}
