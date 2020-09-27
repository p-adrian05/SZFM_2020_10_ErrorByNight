package org.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GameUtilsTest {

    private Board board ;

    @Test
    void isValidBoard() {
        int[][] board1 = {
                {2, 1, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 2, 1, 2}
        };
        int[][] board2 = {
                {0, 0, 2, 1},
                {2, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {1, 0, 1, 2}
        };
        int[][] board3 = {
                {2, 1, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 2, 1, 2}
        };
        int[][] board4 = {
                {2, 1, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 2}
        };
        assertTrue(GameUtils.isValidBoard(board1));
        assertTrue(GameUtils.isValidBoard(board2));
        assertFalse(GameUtils.isValidBoard(board3));
        assertFalse(GameUtils.isValidBoard(board4));
    }

    @Test
    void whereToMove() {
        List<Direction> directions = new ArrayList<>();
        board = new BoardImpl();
        directions.add(Direction.UP);
        assertEquals(directions, GameUtils.whereToMove(4, 3,board.getBoardState()));

        board.swapPieces(4,3, Direction.UP);
        directions.add(Direction.DOWN); directions.add(Direction.LEFT);
        assertEquals(directions, GameUtils.whereToMove(3, 3,board.getBoardState()));

        directions = new ArrayList<>();
        directions.add(Direction.DOWN);
        assertNotEquals(directions, GameUtils.whereToMove(4, 1,board.getBoardState()));
    }
}