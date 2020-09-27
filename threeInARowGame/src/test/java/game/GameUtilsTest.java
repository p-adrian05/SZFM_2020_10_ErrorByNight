package game;

import org.example.game.*;
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

    @Test
    void canMoveUp() {
        assertTrue(GameUtils.canMoveUp(3,1,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.canMoveUp(0,3,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

    @Test
    void canMoveDown() {
        assertTrue(GameUtils.canMoveDown(1,2,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.canMoveDown(1,3,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

    @Test
    void canMoveRight() {
        assertTrue(GameUtils.canMoveRight(3,1,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.canMoveRight(0,3,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

    @Test
    void canMoveLeft() {
        assertTrue(GameUtils.canMoveLeft(3,1,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.canMoveLeft(1,3,new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

        @Test
    void isEnd() {
        assertFalse(GameUtils.isEnd(new BoardImpl().getBoardState()));
        assertTrue(GameUtils.isEnd(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertTrue(GameUtils.isEnd(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertTrue(GameUtils.isEnd(new Piece[][] {
                {Piece.EMPTY, Piece.RED, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.RED},
                {Piece.EMPTY, Piece.BLUE,Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.isEnd(new Piece[][] {
                {Piece.EMPTY, Piece.RED, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.BLUE, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.RED},
                {Piece.EMPTY, Piece.BLUE,Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));

    }

 @Test
    void isThreeInARow() {
        assertTrue(GameUtils.isThreeInARow(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.RED,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.isThreeInARow(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.RED, Piece.BLUE,  Piece.RED,  Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

    @Test
    void isThreeInAColumn() {
        assertTrue(GameUtils.isThreeInAColumn(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.isThreeInAColumn(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

    @Test
    void isThreeInDiagonal() {
        assertTrue(GameUtils.isEnd(new Piece[][] {
                {Piece.EMPTY, Piece.RED, Piece.EMPTY, Piece.BLUE},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.RED},
                {Piece.EMPTY, Piece.BLUE,Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
        assertFalse(GameUtils.isThreeInAColumn(new Piece[][] {
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.BLUE},
                {Piece.EMPTY, Piece.BLUE, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.RED, Piece.RED},
                {Piece.BLUE, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY}
        }));
    }

    @Test
    void makeValidBoard() {
        int[][] board1 = {
                {2, 1, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 2, 1, 2}
        };
        assertTrue(equalsBoard(board1,GameUtils.makeValidBoard("21210000000000001212")));
        assertFalse(equalsBoard(board1,GameUtils.makeValidBoard("21201000000000001212")));
    }

    public boolean equalsBoard(int[][] board1, int[][] board2){
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
