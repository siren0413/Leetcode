package question;

import java.util.*;

/**
 * Created by admin on 1/22/14.
 */
public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (num.length < 3) return totalList;
        Set<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                if (num[start] + num[end] + num[i] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    set.add(list);
                    start++;
                    end--;
                } else if (num[start] + num[end] + num[i] > 0) end--;
                else start++;
            }
        }
        totalList.addAll(set);
        return totalList;
    }


    //test
    public static void main(String[] args) {
        int[] sum = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(sum));
    }
}
