package question;

import java.util.Arrays;

/**
 * Created by admin on 1/20/14.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length / 2, i = 0;
        while(i <=n ){
            for(int k = i ; k < matrix.length-1-i;k++){
                int temp = matrix[i][k];
                matrix[i][k] = matrix[matrix.length-1-k][i];
                matrix[matrix.length-1-k][i] = matrix[matrix.length-1-i][matrix.length-1-k];
                matrix[matrix.length-1-i][matrix.length-1-k] = matrix[k][matrix.length-1-i];
                matrix[k][matrix.length-1-i] = temp;
            }
            i++;
        }
    }


    //test
    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix1 = {
                {1},
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix1));
    }

}
