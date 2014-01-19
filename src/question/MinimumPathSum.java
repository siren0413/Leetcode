package question;

import java.util.Arrays;

/**
 * Created by admin on 1/18/14.
 */
public class MinimumPathSum {

    // iterator DP solution
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[0][0];
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }



    // recursive DP solution
    static int[][] dp;
    public static int minPathSum2(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return minPathSum2Helper(grid,grid.length-1,grid[0].length-1);
    }

    private static int minPathSum2Helper(int[][] grid, int i, int j) {
        if (i ==0 && j== 0) return grid[0][0];
        if (dp[i][j] > 0) return dp[i][j];
        int min = Integer.MAX_VALUE;
        if(i-1 >=0 ) min = Math.min(min,minPathSum2Helper(grid,i-1,j));
        if(j-1>=0) min = Math.min(min,minPathSum2Helper(grid,i,j-1));
        dp[i][j] = min + grid[i][j];
        return dp[i][j];
    }



    //test
    public static void main(String[] args) {
        int[][] grid = {
                {1, 9, 3, 4},
                {3, 2, 5, 8},
                {2, 9, 1, 4},
                {1, 2, 3, 2},
        };
        System.out.println(minPathSum2(grid));
    }
}
