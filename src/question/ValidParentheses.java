package question;

import java.util.*;

/**
 * Created by admin on 1/22/14.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stack.isEmpty()) return false;
                char top = stack.peek();
                switch (top) {
                    case '(': if (s.charAt(i)!=')') return false; else {stack.pop(); break;}
                    case '[': if (s.charAt(i)!=']') return false; else {stack.pop(); break;}
                    case '{': if (s.charAt(i)!='}') return false; else {stack.pop(); break;}
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }


    //test
    public static void main(String[] args) {
        String s = ")";
        System.out.println(isValid(s));
    }
}
