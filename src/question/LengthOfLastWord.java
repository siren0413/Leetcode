package question;

/**
 * Created by admin on 1/19/14.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int start = -1;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                start = i;
                break;
            }
        }
        return s.length() - start - 1;
    }


    // test
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("b    a    "));
    }
}
