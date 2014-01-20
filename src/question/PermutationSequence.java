package question;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by admin on 1/19/14.
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        if(n==0 || k==0 ) return "";
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        k --;
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            int f = factorial(n - 1);
            int i = k / f;
            sb.append(list.remove(i));
            n--;
            k = k % f;
        }
        return sb.toString();
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        int f = 1;
        while (n != 1) f *= n--;
        return f;
    }





    // test
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 6));
    }
}
