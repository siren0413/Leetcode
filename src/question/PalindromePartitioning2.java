package question;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by siren0413 on 1/5/14.
 */
public class PalindromePartitioning2 {
    public static int minCut(String s) {
        if (s == null)
            return 0;
        boolean[][] p = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    p[i][j] = true;
                }
            }
        }

        int[] memo = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int min = s.length();
            for (int j = i; j > 0; j--) {
                if (p[j][i]) {
                    min = memo[j - 1] + 1 < min ? memo[j - 1] + 1 : min;
                }
            }
            memo[i] = min;
        }
        return memo[s.length() - 1];

    }

    private static boolean isPalindrome(String s) {
        if (s.equals(""))
            return false;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("bb"));
    }

}
