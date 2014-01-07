package question;

import java.util.*;

/**
 * Created by siren0413 on 1/6/14.
 */
public class WordLadder {
    public static int ladderLength(String start, String end, HashSet<String> dict) {

        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visit = new HashSet<>();
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (visit.contains(s))
                continue;
            visit.add(s);
            Set<String> set = strList(s, dict);
            for (String str : set) {
                queue.add(str);
                int count = map.get(s);
                if (!map.containsKey(str))
                    map.put(str, count + 1);
            }
        }

        int min = Integer.MAX_VALUE;
        Set<String> endSet = strList(end, dict);
        for (String s : endSet) {
            int i = map.get(s);
            if (i < min)
                min = i;
        }

        if (min == Integer.MAX_VALUE)
            return 0;
        return min + 2;

    }

    private static Set<String> strList(String s, HashSet<String> dict) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char[] arr = s.toCharArray();
                arr[i] = (char) ('a' + j);
                String newStr = new String(arr);
                if (dict.contains(newStr) && !newStr.equals(s))
                    set.add(newStr);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        String start = "hit";
        String end = "cog";
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength(start, end, dict));
    }


}
