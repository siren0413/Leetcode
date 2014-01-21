package question;

import java.util.*;

/**
 * Created by admin on 1/21/14.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) stack.push(i);
            else if (s.charAt(i) == ')') {
                char top = s.charAt(stack.peek());
                if (top == '(')  stack.pop();
                else stack.push(i);
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }

        System.out.println(stack);
        if (stack.isEmpty()) return s.length();
        int len = 0, max = 0;
        for (int i : stack) {
            if (i - len > max) max = i - len;
            len = i + 1;
        }
        if (s.length() - 1 - stack.peek() > max) max = s.length() - 1 - stack.peek();
        return max;
    }


    // test
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((()(()()()()"));
    }
}
