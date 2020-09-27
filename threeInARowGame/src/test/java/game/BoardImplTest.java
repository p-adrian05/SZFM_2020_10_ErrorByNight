package game;

import org.example.game.Board;
import org.example.game.BoardImpl;
import org.example.game.Direction;
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
        Board board = new BoardImpl();
        board.swapPieces(0, 1, Direction.DOWN);
        assertTrue(equalsBoardState(board.getBoardState(), new Piece[][]{
                {Piece.BLUE, Piece.EMPTY, Piece.BLUE, Piece.RED},
                {Piece.EMPTY, Piece.RED, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.RED, Piece.BLUE, Piece.RED, Piece.BLUE}
        }));
    }
    public boolean equalsBoardState(Piece[][] board1, Piece[][] board2){
        for(int i=0;i<5;i++){
            for(int j=0; j<4; j++){
                if(!(board1[i][j] == board2[i][j])){
                    return false;
                }
            }
        }
        return true;
    }


}