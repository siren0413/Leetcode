package question;

import java.util.*;

/**
 * Created by admin on 1/22/14.
 */
public class GenerateParentheses {
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if(n == 0) return list;
        StringBuilder sb = new StringBuilder();
        generateParenthesisHelper(n*2,0,sb,list);
        return list;
    }

    private static void generateParenthesisHelper(int n, int val, StringBuilder sb, ArrayList<String> list) {
        if (n == 0) {
            if(val == 0) list.add(sb.toString());
            return;
        }
        generateParenthesisHelper(n - 1, val + 1, sb.append("("), list);
        sb.deleteCharAt(sb.length()-1);
        if (val - 1 >= 0){
            generateParenthesisHelper(n - 1, val - 1, sb.append(")"), list);
            sb.deleteCharAt(sb.length()-1);
        }

    }



    //test
    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
}
