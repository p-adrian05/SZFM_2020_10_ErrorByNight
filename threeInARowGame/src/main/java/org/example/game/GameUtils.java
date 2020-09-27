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
}
