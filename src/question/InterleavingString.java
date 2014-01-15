package question;

import java.util.Arrays;

/**
 * Created by admin on 1/14/14.
 */
public class InterleavingString {

    static int[][] memo;

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s1.isEmpty() && s3.isEmpty()) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new int[s1.length() + 1][s2.length() + 1];
        return isInterleaveHelper(s1, s2, s3, 0, 0, 0);
    }

    // recursive DP solution
    private static boolean isInterleaveHelper(String s1, String s2, String s3, int i1, int i2, int i3) {
        if (i3 == s3.length() && i2 == s2.length() && i1 == s1.length()) return true;
        if (memo[i1][i2] == 1) return true;
        if (memo[i1][i2] == 2) return false;
        boolean first = false, second = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3))
            first = isInterleaveHelper(s1, s2, s3, i1 + 1, i2, i3 + 1);
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3))
            second = isInterleaveHelper(s1, s2, s3, i1, i2 + 1, i3 + 1);
        memo[i1][i2] = (first || second) ? 1 : 2;
        return first || second;
    }

    // iterator DP solution
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.isEmpty() && s1.isEmpty() && s3.isEmpty()) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1;i<s1.length();i++)
            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]) dp[i][0] = true;
        for(int i = 1;i<s2.length();i++)
            if(s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1]) dp[0][i] = true;

        for(int i = 1; i <= s1.length() ; i++){
            for(int j = 1; j <= s2.length(); j++)
                dp[i][j] = (dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1))) || (dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1)));
        }

        return dp[s1.length()][s2.length()];

    }




    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave2(s1, s2, s3));
    }
}
