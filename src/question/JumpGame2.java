package question;

/**
 * Created by admin on 1/20/14.
 */
public class JumpGame2 {

    // recursive DP
    static int[] dp;

    public static int jump(int[] A) {
        dp = new int[A.length];
        return jumpHelper(A, 0);
    }

    private static int jumpHelper(int[] A, int i) {
        if (i == A.length - 1) return 0;
        if (dp[i] > 0) return dp[i];
        int min = A.length;
        for (int k = 1; k <= A[i]; k++) {
            if (i + k < A.length) min = Math.min(min, jumpHelper(A, i + k) + 1);
        }
        dp[i] = min;
        return min;
    }

    // iterator DP
    public static int jump2(int[] A) {
        int[] dp = new int[A.length];
        dp[A.length - 1] = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            int min = A.length;
            for (int j = 1; j <= A[i]; j++) {
                if (i + j > A.length - 1) break;
                min = Math.min(min, dp[i + j] + 1);
            }
            dp[i] = min;
        }
        return dp[0];
    }


    // greedy algorithm
    public static int jump3(int[] A) {
        int count = 0;
        int i = 0;
        while (i < A.length-1) {
            int max = 0;
            int index = 0;
            for (int j = i+1; j <= i+A[i]; j++) {
                if( j >= A.length-1) return count+1;
                if (j + A[j] > max) {
                    max = j+A[j];
                    index = j;
                }
            }
            i  = index;
            count++;
        }
        return count;
    }


    // test
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        System.out.println(jump3(A));
    }
}
