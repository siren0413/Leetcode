package question;

import java.util.Arrays;

/**
 * Created by admin on 1/18/14.
 */
public class UniquePaths2 {

    // iterator DP solution
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
                else if (i == 0 && j == 0) obstacleGrid[0][0] = 1;
                else if (i == 0) obstacleGrid[i][j] = obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1];
                else if (j == 0) obstacleGrid[i][j] = obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j];
                else obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j]) + (obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1]);
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1]==-1? 0 :obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    //test
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
