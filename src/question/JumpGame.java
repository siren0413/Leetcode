package question;

/**
 * Created by admin on 1/19/14.
 */
public class JumpGame {

    // observation
    public static boolean canJump(int[] A) {
        if (A.length == 1 && A[0] == 0) return true;
        if (A[0] == 0) return false;
        int debt = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > debt - i) debt = 0;
            if (debt == 0 && A[i] == 0) {
                debt = i;
            }
        }
        if (debt != 0) return false;
        return true;
    }


    // better DP
    public static boolean canJump2(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (dp[i - 1] == 0) return false;
            dp[i] = Math.max(A[i], dp[i - 1] - 1);
        }
        return true;
    }



    //test
    public static void main(String[] args) {
        int[] A = {2, 0,2};
        System.out.println(canJump2(A));
    }
}
