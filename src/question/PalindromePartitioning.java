package question;

import java.util.ArrayList;

/**
 * Created by siren0413 on 1/5/14.
 */
public class PalindromePartitioning {
    public static ArrayList<ArrayList<String>> partition(String s) {
        if (s == null)
            return null;
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        helper(s, new ArrayList<String>(), list);
        return list;
    }

    private static void helper(String s, ArrayList<String> pList, ArrayList<ArrayList<String>> list) {
        if (s.equals("")) {
            list.add(new ArrayList<String>(pList));
            pList.remove(pList.size() - 1);
            return;
        }

        for (int i = 0; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                pList.add(s.substring(0, i));
                helper(s.substring(i, s.length()), pList, list);
            }
        }
        if (!s.equals("") && !pList.isEmpty()) {
            pList.remove(pList.size() - 1);
        }

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
        String s = "abaa";
        System.out.println(partition(s));
    }

}
