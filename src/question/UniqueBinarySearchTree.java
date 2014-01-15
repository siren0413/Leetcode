package question;

/**
 * Created by admin on 1/14/14.
 */
public class UniqueBinarySearchTree {

    // recursive DP solution
    static int[] dp;

    public static int numTrees(int n) {
        dp = new int[n + 1];
        return numTreesHelper(n);
    }

    private static int numTreesHelper(int n) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] > 0) return dp[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numTreesHelper(i) * numTreesHelper(n - i - 1);
        }
        dp[n] = sum;
        return sum;
    }


    // iterator DP solution
    public static int numTrees2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }



    //test
    public static void main(String[] args) {
        System.out.println(numTrees2(3));
    }
}
