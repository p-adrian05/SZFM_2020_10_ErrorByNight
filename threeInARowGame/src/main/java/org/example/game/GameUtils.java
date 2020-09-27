package org.example.game;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    public static boolean isValidBoard(int[][] board) {
        if (board == null || board.length != 5) {
            return false;
        }
        int countRed = 0;
        int countBlue = 0;
        for (int[] row : board) {
            if (row == null || row.length != 4) {
                return false;
            }
            for (int a : row) {
                if (a < 0 || a > Piece.values().length) {
                    return false;
                }
                countBlue += (a == 2) ? 1 : 0;
                countRed += (a == 1) ? 1 : 0;
            }
        }
        return countBlue == 4 && countRed == 4;
    }

    public static List<Direction> whereToMove(int row, int column, Piece[][] boardData) {
        List<Direction> directions = new ArrayList<>();

        if (canMoveUp(row, column, boardData)) {
            directions.add(Direction.UP);
        }
        if (canMoveDown(row, column, boardData)) {
            directions.add(Direction.DOWN);
        }
        if (canMoveRight(row, column, boardData)) {
            directions.add(Direction.RIGHT);
        }
        if (canMoveLeft(row, column, boardData)) {
            directions.add(Direction.LEFT);
        }

        return directions;

    }
    
      public static boolean canMoveUp(int row, int column, Piece[][] boardData){
        if(boardData[row][column]==Piece.EMPTY){
            throw new IllegalArgumentException();
        }
        return (row-1)>=0 && (row-1)<5 && boardData[row-1][column]==Piece.EMPTY;
    }

    public static boolean canMoveDown(int row, int column, Piece[][] boardData){
        if(boardData[row][column]==Piece.EMPTY){
            throw new IllegalArgumentException();
        }
        return (row+1)>=0 && (row+1)<5 && boardData[row+1][column]==Piece.EMPTY;
    }

    public static boolean canMoveRight(int row, int column,Piece[][] boardData){
        if(boardData[row][column]==Piece.EMPTY){
            throw new IllegalArgumentException();
        }
        return (column+1)>=0 && (column+1)<4 && boardData[row][column+1]==Piece.EMPTY;
    }

    public static boolean canMoveLeft(int row, int column,Piece[][] boardData){
        if(boardData[row][column]==Piece.EMPTY){
            throw new IllegalArgumentException();
        }
        return (column-1)>=0 && (column-1)<4 && boardData[row][column-1]==Piece.EMPTY;
    }
    
        /**
     * Checks whether the game is ended.
     *
     * @return {@code true} if one of the players has 3 piece in a row, column or diagonal,
     * {@code false} otherwise
     */
    public static boolean isEnd(Piece[][] boardData) {
        return isThreeInARow(boardData) || isThreeInAColumn(boardData) || isThreeInDiagonal(boardData);
    }

    public static boolean isThreeInARow(Piece[][] boardData){
        for(Piece[] row:boardData){
            for(int i=0; i<2; i++){
                if(row[i]==row[i+1] && row[i]==row[i+2] && row[i]!=Piece.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isThreeInAColumn(Piece[][] boardData){
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(boardData[i][j]==boardData[i+1][j] && boardData[i][j]==boardData[i+2][j] && boardData[i][j]!=Piece.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isThreeInDiagonal(Piece[][] boardData){
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                if(j+2<4){
                    if(boardData[i][j]==boardData[i+1][j+1] && boardData[i][j]==boardData[i+2][j+2] && boardData[i][j]!=Piece.EMPTY){
                        return true;
                    }
                }
                if(j-2>=0){
                    if(boardData[i][j]==boardData[i+1][j-1] && boardData[i][j]==boardData[i+2][j-2] && boardData[i][j]!=Piece.EMPTY){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
     public static int[][] makeValidBoard(String state){
        int[][] board = new int[5][4];
        for(int i=0;i<5;i++){
            for(int j=0; j<4; j++){
                board[i][j] = Character.getNumericValue(state.charAt(i*4+j));
            }
        }
        return board;
    }

    public static String createStringFromGameState(Piece[][] boardData){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                sb.append(boardData[i][j].getValue());
            }
        }
        return sb.toString();
    }
    
}
