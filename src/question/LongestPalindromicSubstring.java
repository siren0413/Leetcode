package question;

/**
 * Created by admin on 1/23/14.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.isEmpty()) return s;
        int max = -1;
        String p = s.substring(0,1);
        for(int i = 1; i < s.length(); i++){
            int len = palindromeLength(s,i,i);
            if(len > max){
                max = len;
                p = s.substring(i-len/2,i+1+len/2);
            }
            if(s.charAt(i)==s.charAt(i-1)){
                len = palindromeLength(s,i-1,i);
                if(len > max){
                    max = len;
                    p = s.substring(i-len/2,i+len/2);
                }
            }
        }
        return p;
    }

    private static int palindromeLength(String s, int i, int j) {
        int len = i == j ? -1 : 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                len = len + 2;
                i--;
                j++;
            } else
                return len;
        }
        return len;
    }


    //test
    public static void main(String[] args){
        System.out.println(longestPalindrome("bb"));
    }
}
