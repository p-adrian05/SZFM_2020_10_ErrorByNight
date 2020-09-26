package org.example.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class BoardImpl implements Board {

    public static final int[][] INITIAL = {
            {2, 1, 2, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 2, 1, 2}
    };
    /**
     * Creates a {@code ThreeInARowState} object representing the initial state
     * of the game.
     */
    public BoardImpl(){
        this(INITIAL);
    }

    @Setter(AccessLevel.NONE)
    @Getter
    private Piece[][] boardState;
    /**
     * The piece which will move
     */
    @Setter(AccessLevel.NONE)
    @Getter
    private Piece turn = Piece.BLUE;

    public BoardImpl(int[][] boardData){
        if(!GameUtils.isValidBoard(boardData)){
            throw new IllegalArgumentException();
        }
        initBoard(boardData);
    }

    private void initBoard(int[][] board){
        this.boardState = new Piece[5][4];
        for(int i=0; i<5;i++){
            for(int j=0; j<4; j++){
                this.boardState[i][j] = Piece.of(board[i][j]);
            }
        }
    }

    /**
     * Switches the {@code turn} to that piece which will move next.
     */
    @Override
    public void nextTurn() {
        
    }

    @Override
    public void swapPieces(int row, int column, Direction direction) {

    }
}
