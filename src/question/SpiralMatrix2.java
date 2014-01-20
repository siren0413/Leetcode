package question;

import java.util.Arrays;

/**
 * Created by admin on 1/19/14.
 */
public class SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int num = 1, i = 0, j = 0, m = n;
        while (num <= n * n) {
            while (j < m) matrix[i][j++] = num++;
            j--;
            i++;

            while (i < m) matrix[i++][j] = num++;
            i--;
            j--;

            while (j >= n - m) matrix[i][j--] = num++;
            j++;
            i--;

            while (i > n - m) matrix[i--][j] = num++;
            i++;
            j++;

            m--;
        }

        return matrix;
    }



    // test
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(2)));
    }
}
