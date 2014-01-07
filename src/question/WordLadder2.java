package question;

import java.util.*;

/**
 * Created by siren0413 on 1/6/14.
 */
public class WordLadder2 {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict){
        Map<String, Integer> map = new HashMap<>();
        Map<String, Set<String>> preWordMap = new HashMap<>();
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
                if (map.get(str)==null || map.get(str)==count+1){
                    map.put(str, count + 1);
                    if(preWordMap.get(str) == null){
                        Set<String> subSet = new HashSet<>();
                        subSet.add(s);
                        preWordMap.put(str,subSet);
                    }else{
                        Set<String> subSet = preWordMap.get(str);
                        subSet.add(s);
                        preWordMap.put(str,subSet);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        Set<String> resultSet = new HashSet<>();
        Set<String> endSet = strList(end, dict);
        for (String s : endSet) {
            int i = map.get(s);
            if (i < min){
                resultSet.clear();
                resultSet.add(s);
                min = i;
            }else if (i== min){
                resultSet.add(s);
            }
        }
        preWordMap.put(end,resultSet);

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> l = new ArrayList<>();
        helper(end, end, preWordMap, list, l);

        return list;

    }

    private static void helper(String str,String end, Map<String,Set<String>> preWordMap, ArrayList<ArrayList<String>> list, ArrayList<String> l){
        Set<String> set = preWordMap.get(str);
        if(set == null){
            ArrayList<String> newList = new ArrayList<>(l);
            Collections.reverse(newList);
            newList.add(end);
            list.add(newList);
            return;
        }
        for(String s: set){
            l.add(s);
            helper(s,end,preWordMap,list,l);
            l.remove(l.size()-1);
        }
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

    public static void main(String[] args){
        HashSet<String> dict = new HashSet<>();
        String start = "red";
        String end = "tax";
        dict.add("ted");
        dict.add("tex");
        dict.add("red");
        dict.add("tax");
        dict.add("tad");
        dict.add("den");
        dict.add("rex");
        dict.add("pee");

        System.out.println(findLadders(start, end, dict));
    }



}
