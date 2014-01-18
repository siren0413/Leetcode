package question;

import java.util.Arrays;

/**
 * Created by admin on 1/17/14.
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        for (int i = 0; i < matrix.length; i++) if (matrix[i][0] == 0) col = true;
        for (int i = 0; i < matrix[0].length; i++) if (matrix[0][i] == 0) row = true;
        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0) for(int j = 1; j < matrix.length; j++ )matrix[j][i] = 0;
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] ==0)for(int j = 1; j < matrix[0].length; j++)  matrix[i][j] = 0;
        }

        if(row)for(int i = 0; i<matrix[0].length;i++) matrix[0][i] = 0;
        if(col) for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;

    }




    // test
    public static void main(String[] args){
        int[][] matrix = {
                {1,1,0,1,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,0,0}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
