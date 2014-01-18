package question;

import java.util.*;

/**
 * Created by admin on 1/17/14.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word, 0, i, j, visit)) return true;
            }
        }
        return false;
    }

    private static boolean existHelper(char[][] board, String word, int n, int i, int j, boolean[][] visit) {
        if (n == word.length()) return true;
        if (j > board[0].length - 1 || j < 0 || i > board.length - 1 || i < 0 || visit[i][j] || board[i][j] != word.charAt(n) ) return false;

        visit[i][j] = true;
        if(existHelper(board, word, n + 1, i + 1, j, visit)) return true;
        if(existHelper(board, word, n + 1, i - 1, j, visit)) return true;
        if(existHelper(board, word, n + 1, i, j - 1, visit)) return true;
        if(existHelper(board, word, n + 1, i, j + 1, visit)) return true;
        visit[i][j] = false;
        return false;
    }



    // test
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'A'},
                {'A', 'A'}

        };
        System.out.println(exist(board, "AAAA"));
    }
}
