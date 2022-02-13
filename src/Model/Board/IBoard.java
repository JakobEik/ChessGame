package Model.Board;

import Model.ChessPieces.IChessPiece;

public interface IBoard {

    IChessPiece getSquare(int x, int y);
    void movePiece(IChessPiece piece, int x, int y);
}
