package org.example.game;

import org.example.gamedb.GameState;
import org.example.gamedb.GameStateDao;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    GameService gameService = GameServiceImpl.getInstance();

    @Test
    void getWinnerName() {
        gameService.reset();
        assertEquals(Piece.RED.name(),gameService.getWinnerName());
    }

    @Test
    void getTurnPlayerName() {
        gameService.reset();
        assertEquals(Piece.BLUE.name(),gameService.getTurnPlayerName());
        gameService.movePieceTo(0,0,Direction.DOWN);
        assertEquals(Piece.RED.name(),gameService.getTurnPlayerName());
    }
}