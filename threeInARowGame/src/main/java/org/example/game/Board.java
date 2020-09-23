package org.example.game;

public interface Board {

    /**
     * Switches the {@code turn} to that piece which will move next.
     */
    void nextTurn();
    void swapPieces(int row, int column, Direction direction);
    Piece getTurn();
    Piece[][] getBoardState();
}
