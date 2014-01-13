package question;

import java.util.Arrays;

/**
 * Created by admin on 1/11/14.
 */
public class DistinctSubsequences {

    // recursive DP solution
    public static int numDistinct(String S, String T) {
        int[][] memo = new int[S.length()][T.length()];
        for(int i = 0 ;i < memo.length; i++){
            for(int j = 0 ; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }
        return numDistinctHelper(S, T, 0, 0, memo);
    }

    private static int numDistinctHelper(String S, String T, int i, int j, int[][] memo) {
        if (j == T.length())
            return 1;
        if(i == S.length())
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];

        int cnt = 0;
        if (S.charAt(i) == T.charAt(j)) {
            cnt += numDistinctHelper(S, T, i + 1, j + 1, memo) + numDistinctHelper(S, T, i + 1, j, memo);
        } else {
            cnt += numDistinctHelper(S, T, i + 1, j, memo);
        }

        memo[i][j] = cnt;
        return cnt;
    }

    // iterator DP solution
    public static int numDistinct2(String S, String T){
        int[][] memo = new int[T.length()+1][S.length()+1];
        for(int i = 0; i < S.length()+1; i++){
            memo[0][i] = 1;
        }
        for(int i =1 ; i < T.length()+1; i++){
            for(int j = 1; j < S.length()+1; j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    memo[i][j] = memo[i][j-1] + memo[i-1][j-1];
                }else{
                    memo[i][j] = memo[i][j-1];
                }
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return memo[T.length()][S.length()];
    }

    public static int numDistinct3(String S, String T){
        // input check
        if(S.isEmpty()){
            if(T.isEmpty())
                return 1;
            else
                return 0;
        }

        // initialize bottom optimum solution.
        int[][] memo = new int[T.length()][S.length()];
        memo[0][0] = T.charAt(0)==S.charAt(0)?1:0;
        for(int i = 1; i < S.length(); i++){
            memo[0][i] = T.charAt(0) == S.charAt(i)?memo[0][i-1] + 1: memo[0][i-1];
        }

        // build up solution
        for(int i =1 ; i < T.length(); i++){
            for(int j = 1; j < S.length(); j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    memo[i][j] = memo[i][j-1] + memo[i-1][j-1];
                }else{
                    memo[i][j] = memo[i][j-1];
                }
            }
        }

        return memo[T.length()-1][S.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct2("rabbbit", "rabbit"));
        System.out.println(numDistinct3("rabbbit", "rabbit"));
    }


}
