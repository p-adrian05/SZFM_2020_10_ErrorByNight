package org.example.game;

import org.example.gamedb.GameState;

import java.util.List;

public interface GameService {

    String getWinnerName();
    String getTurnPlayerName();
    boolean gameOver();
    Piece[][] getBoardData();
    Piece getNextTurn();
    List<Direction> getPossibleMoves(int clickedRow, int clickedColumn);
    /**
     * Moves the piece from the specified position to the specified direction.
     *
     * @param clickedRow the row of the piece to be moved
     * @param clickedColumn the column of the piece to be moved
     * @param direction the direction of the movement
     * @throws IllegalArgumentException if the specified position is empty or the specified
     * direction is impossible on that piece or the piece in the specified position is not the
     * one which will move
     */
    void movePieceTo(int clickedRow, int clickedColumn, Direction direction)throws IllegalArgumentException;
    void setPlayersName(String playerRed, String playerBlue);
    List<GameState> getAllSavedGameStates();

    boolean loadState(GameState gameState);

    void deleteGameStateByID(Long id);
    boolean saveGameState();
    void reset();
}
