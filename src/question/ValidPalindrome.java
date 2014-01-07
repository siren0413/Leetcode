package question;

/**
 * Created by siren0413 on 1/6/14.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s){
        if(s == null)
            return false;
        if(s.isEmpty())
            return true;
        int start = 0;
        int end = s.length() -1;
        while(start < end){
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(!isAlpha(left)){
                start++;
                continue;
            }
            if(!isAlpha(right)){
                end--;
                continue;
            }
            left = toLowerCase(left);
            right = toLowerCase(right);

            if(left != right)
                return false;
            start++;
            end--;
        }
        return true;

    }

    private static boolean isAlpha(char c){
        if((c<='Z' && c>='A') || (c<='z' && c>='a') || (c<='9' && c>='0'))
            return true;
        return false;
    }

    private static char toLowerCase(char c){
        if(c<='Z' && c>= 'A')
            c = (char)(c - 'A' + 'a');
        return c;
    }

    public static void main(String[] args){
        String s = "1a2";
        System.out.println(isPalindrome(s));
    }
}
