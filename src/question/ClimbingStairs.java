package question;

/**
 * Created by admin on 1/18/14.
 */
public class ClimbingStairs {

    // iterator DP solution
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



    // recursive DP solution
    static int[] dp;
    public static int climbStairs2(int n) {
        dp = new int[n+1];
        return climbStairs2Helper(n);
    }

    private static int climbStairs2Helper(int n){
        if (n == 0 || n ==1) return 1;
        if(dp[n] > 0) return dp[n];
        dp[n] =  climbStairs2Helper(n - 1) + climbStairs2Helper(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(3));
    }

}
