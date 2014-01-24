package question;

import java.util.*;

/**
 * Created by admin on 1/22/14.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static ArrayList<String> letterCombinations(String digits){
        ArrayList<String> list = new ArrayList<>();
        if(digits.isEmpty()) {
            list.add("");
            return list;
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits,map,0,sb,list);
        return list;
    }

    private static void letterCombinationsHelper(String digits, Map<Integer,String> map, int i, StringBuilder sb, ArrayList<String> list){
        if(i >= digits.length()){
            list.add(sb.toString());
            return;
        }
        int num = digits.charAt(i) - '0';
        String letters = map.get(num);
        for(int k = 0 ; k < letters.length(); k++){
            letterCombinationsHelper(digits,map,i+1,sb.append(letters.charAt(k)),list);
            sb.deleteCharAt(sb.length()-1);
        }
    }



    //test
    public static void main(String[] args){
        String digits = "27";
        System.out.println(letterCombinations(digits));
    }


}
