package question;

import java.util.Arrays;

/**
 * Created by admin on 1/18/14.
 */
public class UniquePaths {

    // using combinations
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        return (int) (factorial(m + n - 2) / (factorial(m - 1) * factorial(n - 1)));
    }

    private static long factorial(int n) {
        long res = 1;
        while (n != 1) res *= n--;
        return res;
    }


    // iterator DP solution
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[0][0] = 1;
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    // recursive DP solution
    static int[][] dp;

    public static int uniquePath3(int m, int n) {
        dp = new int[m][n];
        return uniquePath3Helper(m - 1, n - 1);
    }

    private static int uniquePath3Helper(int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] > 0) return dp[i][j];
        if (i > 0 && j > 0) dp[i][j] = uniquePath3Helper(i - 1, j) + uniquePath3Helper(i, j - 1);
        else if (i > 0) dp[i][j] = uniquePath3Helper(i - 1, j);
        else if (j > 0) dp[i][j] = uniquePath3Helper(i, j - 1);
        return dp[i][j];
    }


    //test
    public static void main(String[] args) {
        //System.out.println(factorial(35));
        System.out.println(uniquePaths2(36, 7));
    }
}
