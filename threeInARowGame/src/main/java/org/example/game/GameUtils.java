package org.example.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameUtils {

    public static boolean isValidBoard(int[][] board){
        return true;
    }

    public static List<Direction> whereToMove(int row, int column, Piece[][] boardData){return new LinkedList<>();}
    public static boolean canMoveUp(int row, int column, Piece[][] boardData){
        return true;
    }

    public static boolean canMoveDown(int row, int column, Piece[][] boardData){
        return true;
    }

    public static boolean canMoveRight(int row, int column,Piece[][] boardData){
        return true;
    }

    public static boolean canMoveLeft(int row, int column,Piece[][] boardData){
        return true;
    }

    /**
     * Checks whether the game is ended.
     *
     * @return {@code true} if one of the players has 3 piece in a row, column or diagonal,
     * {@code false} otherwise
     */
    public static boolean isEnd(Piece[][] boardData) {
        return true;
    }

    public static boolean isThreeInARow(Piece[][] boardData){
        return true;
    }

    public static boolean isThreeInAColumn(Piece[][] boardData){
        return true;
    }

    public static boolean isThreeInDiagonal(Piece[][] boardData){
        return true;
    }
    public static int[][] makeValidBoard(String state){
        return new int[1][1];
    }

    public static String createStringFromGameState(Piece[][] boardData){
        return "";
    }

}
