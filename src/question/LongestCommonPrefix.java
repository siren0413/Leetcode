package question;

/**
 * Created by admin on 1/22/14.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int k = 0;
        StringBuilder prefix = new StringBuilder();
        while (true) {
            char c ='0';
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() - 1 < k) return prefix.toString();
                if (i == 0) c = strs[i].charAt(k);
                else if (strs[i].charAt(k) != c) return prefix.toString();
            }
            prefix.append(strs[0].charAt(k));
            k++;
        }
    }



    // test
    public static void main(String[] args){
        String[] strs = {"nihao","nifds","niwrewr"};
        System.out.println(longestCommonPrefix(strs));
    }
}
