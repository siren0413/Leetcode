package question;

import java.util.*;

/**
 * Created by admin on 1/19/14.
 */
public class Anagrams {

    public static ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);
            if (!map.containsKey(sortedString)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedString, list);
            } else {
                map.get(sortedString).add(s);
            }
        }

        ArrayList<String> totalList = new ArrayList<>();
        for (ArrayList<String> list : map.values()) {
            if (list.size() > 1) totalList.addAll(list);
        }

        return totalList;
    }



    // test
    public static void main(String[] args){
        String[] strs = {"tea", "and", "ate", "eat", "dan"};
        System.out.println(anagrams(strs));
    }



}
