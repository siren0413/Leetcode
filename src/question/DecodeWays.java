package question;

import java.util.Arrays;

/**
 * Created by admin on 1/15/14.
 */
public class DecodeWays {

    static int[] dp;
    public static int numDecodings(String s){
        if(s.isEmpty()) return 0;
        dp = new int[s.length()];
        for(int i = 0; i < dp.length; i++)
            dp[i] = -1;
        return numDecodingsHelper(s,0);
    }

    private static int numDecodingsHelper(String s,int i){
        if(i == s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        int first=0, second = 0;
        if(i+1 <= s.length() && s.charAt(i)!='0')
            first = numDecodingsHelper(s,i+1);
        if(i+2 <= s.length() && s.charAt(i)!='0' && Integer.valueOf(s.substring(i,i+2))<=26)
            second = numDecodingsHelper(s,i+2);
        dp[i] = first + second;
        return dp[i];
    }



    // test
    public static void main(String[] args){
        String s = "1232112312";
        System.out.println(numDecodings(s));
    }
}
