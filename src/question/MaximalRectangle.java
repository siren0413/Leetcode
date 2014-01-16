package question;

/**
 * Created by admin on 1/16/14.
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int diag = scanDiag(matrix, i, j,0);
                    for(int k = 1; k <= diag; k++)
                        max = Math.max(max,Math.max(scanRight(matrix, i, j, k),scanDown(matrix, i, j, k)));
                }
            }
        }
        return max;
    }

    private static int scanDiag(char[][] matrix, int i, int j,int n) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') return 0;
        for(int k = i; k >= i-n; k--)
            if(matrix[k][j] == '0') return 0;
        for(int k = j; k >= j-n; k--)
            if(matrix[i][k] == '0') return 0;
        return scanDiag(matrix, i + 1, j + 1,n+1) + 1;
    }

    private static int scanRight(char[][] matrix, int i, int j, int n) {
        if (j >= matrix[0].length) return 0;
        for (int k = i; k < i + n; k++)
            if (matrix[k][j] == '0') return 0;
        return scanRight(matrix, i, j + 1, n) + n;
    }

    private static int scanDown(char[][] matrix, int i, int j, int n) {
        if (i >= matrix.length) return 0;
        for (int k = j; k < j + n; k++)
            if (matrix[i][k] == '0') return 0;
        return scanDown(matrix, i + 1, j, n) + n;
    }




    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '0', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }
}
