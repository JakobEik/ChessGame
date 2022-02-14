package Model.ChessPieces;

import Model.HelperClasses.Position;
import Model.Moves.IMove;

import java.util.*;

public class Pawn extends ChessPiece{
    private static final int value = 100;
    private final static Collection<IMove> moves = Collections.unmodifiableSet(
            Set.of(CONSTANT_1, CONSTANT_2, CONSTANT_3));

    public Pawn(Position position, boolean isWhite) {
        super(position, value, isWhite);
    }

    @Override
    public Collection<IMove> getMoves() {
        //TODO: implement method
        return null;
    }
}
