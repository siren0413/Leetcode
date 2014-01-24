package question;

import java.util.*;


/**
 * Created by admin on 1/22/14.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int diff = num[start] + num[end] + num[i] - target;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    sum = num[start] + num[end] + num[i];
                }
                if (diff == 0) return sum;
                if (diff > 0) end--;
                else start++;
            }
        }
        return sum;
    }


    //test
    public static void main(String[] args) {
        int[] sum = {0, 2, 1, -3};
        System.out.println(threeSumClosest(sum, 1));
    }
}
