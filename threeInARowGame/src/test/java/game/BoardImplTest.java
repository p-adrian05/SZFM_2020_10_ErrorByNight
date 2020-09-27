package game;

import org.example.game.Board;
import org.example.game.BoardImpl;
import org.example.game.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardImplTest {

    @Test
    void initBoard() {
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(null));
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(new int[][]{
                {1, 2},
                {2, 0}})
        );
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(new int[][]{
                {0, 0, 0, 1},
                {1, 2, 0, 2},
                {0, 0, 1, 0}})
        );
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 2},
                {0, 1, 2, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}})
        );
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 2},
                {0, 1, 2, 0},
                {1, 0, 2, 0},
                {0, 3, 0, 2}})
        );
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(new int[][]{
                {0, 0, 1, 0},
                {1, 0, 0, 2},
                {0, 2, 2, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}})
        );
    }

    @Test
    void nextTurn() {
        Board board = new BoardImpl();
        assertEquals(Piece.RED,board.nextTurn());
        assertEquals(Piece.BLUE,board.nextTurn());
        assertEquals(Piece.RED,board.nextTurn());
        assertEquals(Piece.BLUE,board.nextTurn());
    }

    @Test
    void swapPieces() {
    }


}