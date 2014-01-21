package question;

import java.util.*;

/**
 * Created by admin on 1/20/14.
 */
public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    private static boolean solveSudokuHelper(char[][] board, int i, int j) {
        if (i == board.length) return true;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) ('0' + k);
                if (isValid(board, i, j)) {
                    boolean result = false;
                    if (j + 1 < board[0].length)
                        result = solveSudokuHelper(board, i, j + 1);
                    else
                        result = solveSudokuHelper(board, i + 1, 0);
                    if (result) return true;
                }
                board[i][j] = '.';
            }
        } else {
            boolean result = false;
            if (j + 1 < board[0].length)
                result = solveSudokuHelper(board, i, j + 1);
            else
                result = solveSudokuHelper(board, i + 1, 0);
            if (result) return true;
        }
        return false;
    }

    private static boolean isValid(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == '.') continue;
            if (!set.contains(board[i][k])) set.add(board[i][k]);
            else return false;
        }
        set.clear();
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == '.') continue;
            if (!set.contains(board[k][j])) set.add(board[k][j]);
            else return false;
        }
        set.clear();
        for (int m = 3 * (i / 3); m < 3 * (i / 3 + 1); m++) {
            for (int n = 3 * (j / 3); n < 3 * (j / 3 + 1); n++) {
                if (board[m][n] == '.') continue;
                if (!set.contains(board[m][n])) set.add(board[m][n]);
                else return false;
            }
        }
        return true;
    }


    // test
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '3', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
