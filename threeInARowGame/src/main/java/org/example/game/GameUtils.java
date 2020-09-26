package org.example.game;


public class GameUtils {

    public static boolean isValidBoard(int[][] board){
        if(board == null || board.length != 5){
            return false;
        }
        int countRed=0;
        int countBlue=0;
        for(int[] row:board){
            if(row == null || row.length !=4){
                return false;
            }
            for(int a:row){
                if(a<0 || a>Piece.values().length){
                    return false;
                }
                countBlue += (a==2)?1:0;
                countRed += (a==1)?1:0;
            }
        }
        return countBlue == 4 && countRed == 4;
    }

  
