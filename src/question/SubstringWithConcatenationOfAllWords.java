package question;

import java.util.*;

/**
 * Created by admin on 1/21/14.
 */
public class SubstringWithConcatenationOfAllWords {
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<>();
        if (L.length == 0 || S.isEmpty()) return list;
        Map<String, Integer> map = new HashMap<>();
        for (String s : L) {
            if (!map.containsKey(s)) map.put(s, 1);
            else map.put(s, map.get(s) + 1);
        }
        int subLen = L[0].length(), length = L.length * L[0].length();
        for (int i = 0; i < S.length() - length + 1; i++) {
            if (findSubstringHelper(S, map, i, subLen, i + length)) list.add(i);
        }
        return list;
    }

    private static boolean findSubstringHelper(String S, Map<String, Integer> map, int i, int subLen, int length) {
        if (i >= length) {
            return true;
        }

        String str = S.substring(i, i + subLen);
        if (map.containsKey(str)) {
            if (map.get(str) == 0) return false;
            map.put(str, map.get(str) - 1);
            if (findSubstringHelper(S, map, i + subLen, subLen, length)) {
                map.put(str, map.get(str) + 1);
                return true;
            }
            map.put(str, map.get(str) + 1);
        }
        return false;

    }




    // test
    public static void main(String[] args) {
        String S = "barfoothefoobar";
        String[] L = {"foo", "bar"};
        System.out.println(findSubstring(S, L));
    }
}
