package question;

import java.util.*;

/**
 * Created by admin on 1/23/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // using map
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.size() > max) max = map.size();
                int index = map.get(s.charAt(i));
                Map<Character, Integer> newMap = new HashMap<>();
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > index) {
                        newMap.put(entry.getKey(), entry.getValue());
                    }
                }
                map = newMap;
            }
            map.put(s.charAt(i), i);
        }
        if (map.size() > max) max = map.size();   // don't forget this
        return max;
    }

    // using ASCII array
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) return s.length();
        int max = -1, i = 0, j = 0;
        boolean[] exist = new boolean[256];
        while (i < s.length()) {
            if (exist[s.charAt(i)]) {
                while (s.charAt(j) != s.charAt(i)) {
                    exist[s.charAt(j)] = false;
                    j++;
                }
                j++;
            }
            if (i - j + 1 > max) max = i - j + 1;
            exist[s.charAt(i)] = true;
            i++;
        }
        return max;
    }


    // test
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("auxyabcdefghi"));
    }
}
