package question;

import java.util.Arrays;

/**
 * Created by siren0413 on 1/5/14.
 */
public class SurroundedRegions {
    public static void solve(char[][] board){
        boolean[][] visit = new boolean[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if((i==0 ||i==board.length-1 || j==0 || j==board.length-1) && board[i][j] == 'O'){
                    helper(board,visit,i,j,'Y');
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='Y'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void helper(char[][] board,boolean[][] visit, int i, int j, char c){
        if(i<0 || i>=board.length || j<0 || j>=board.length || board[i][j] == 'X' || visit[i][j])
            return;
        board[i][j] = c;
        visit[i][j] = true;
        helper(board,visit,i-1,j,c);
        helper(board,visit,i,j-1,c);
        helper(board,visit,i+1,j,c);
        helper(board,visit,i,j+1,c);
    }

    public static void solve2(char[][] board){
        if(board == null || board.length == 0)
            return;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if((i==0 ||i==board.length-1 || j==0 || j==board.length-1) && board[i][j] == 'O'){
                    board[i][j]='Y';
                }
            }
        }
        for(int i = 0; i < board.length-1; i++){
            for(int j = 0; j<board[0].length-1; j++){
                if(board[i][j]=='Y'){
                    if(j+1<board[0].length && board[i][j+1]!= 'Y'){
                        board[i][j+1] = 'Y';
                    }
                    for(int k = j-1; k>=0;k--){
                        if(board[i][k]=='O'){
                            board[i][k] = 'Y';
                        }
                        else
                            break;
                    }
                    for(int k = j+1; k<board[0].length;k++){
                        if(board[i][k]=='O'){
                            board[i][k] = 'Y';
                        }
                        else
                            break;
                    }
                }
            }
        }

        for(int i = 0; i < board.length-1; i++){
            for(int j = 0; j<board[0].length-1; j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 'Y'){
                    board[i][j]='O';
                }
            }
        }
    }

    public static void main(String[] args){
        char[][] board = {
                {'O','O'},
                {'O','O'}

        };

        solve2(board);
        System.out.println(Arrays.deepToString(board));
    }
}
