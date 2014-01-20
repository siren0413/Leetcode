package question;

import java.util.ArrayList;

/**
 * Created by admin on 1/19/14.
 */
public class SpiralMatrix {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        while (i == j && (m > i && n > j)) {
            if(j>=n) break;
            while (j < n)list.add(matrix[i][j++]);   // top
            j--;
            i++;

            if( i>=m )break;
            while (i < m)list.add(matrix[i++][j]);   // right
            i--;
            j--;

            if(j < matrix[0].length -n) break;
            while (j >= matrix[0].length - n)list.add(matrix[i][j--]);  // bottom
            j++;
            i--;

            if( i <= matrix.length -m) break;
            while (i > matrix.length - m)list.add(matrix[i--][j]);   // left
            i++;
            j++;

            m -= 1;
            n -= 1;
        }
        return list;
    }






// test
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrix4 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };

        int[][] matrix5 = {
                {1},
                {3},
                {5},
                {7}
        };
        System.out.println(spiralOrder(matrix5));
    }

}
