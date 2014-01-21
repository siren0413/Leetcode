package question;

import java.util.*;

/**
 * Created by admin on 1/20/14.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!checkRow(board, i)) return false;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (!checkCol(board, i)) return false;
        }
        int[] index = {0,3,6};
        for(int i = 0; i < index.length; i++){
            for(int j = 0; j < index.length; j++){
                if(!checkBox(board,index[i],index[j]))  return false;
            }
        }

        return true;
    }


    private static boolean checkRow(char[][] board, int i) {
        if (i < 0 || i > 8) return false;
        Set<Integer> set = new HashSet<>();
        for (int m = 0; m < board[0].length; m++) {
            if (board[i][m] == '.') continue;
            if (!set.contains(board[i][m] - '0'))
                set.add(board[i][m] - '0');
            else
                return false;
        }
        return true;
    }

    private static boolean checkCol(char[][] board, int i) {
        if (i < 0 || i > 8) return false;
        Set<Integer> set = new HashSet<>();
        for (int m = 0; m < board[0].length; m++) {
            if (board[m][i] == '.') continue;
            if (!set.contains(board[m][i] - '0'))
                set.add(board[m][i] - '0');
            else
                return false;
        }
        return true;
    }

    private static boolean checkBox(char[][] board, int i, int j) {
        Set<Integer> set = new HashSet<>();
        for (int m = i; m <= i+2; m++) {
            for (int n = j; n <= j+2; n++) {
                if (board[m][n] == '.') continue;
                if (!set.contains(board[m][n] - '0'))
                    set.add(board[m][n] - '0');
                else
                    return false;
            }
        }
        return true;
    }




    //test
    public static void main(String[] args){
        char[][] board = {
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','3','.','.'},
                {'.','.','.','1','8','.','.','.','.'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','.','1','.','9','7','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
        };
        System.out.println(isValidSudoku(board));
    }
}
