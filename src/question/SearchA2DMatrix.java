package question;

/**
 * Created by admin on 1/17/14.
 */
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if(matrix[i][j] == target) return true;
            else if( matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }



    // test
    public static void main(String[] args){
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println(searchMatrix(matrix,3));
    }
}