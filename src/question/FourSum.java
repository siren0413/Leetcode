package question;

import java.util.*;


/**
 * Created by admin on 1/22/14.
 */
public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (num.length < 4) return totalList;
        Set<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int start = j + 1, end = num.length - 1;
                while (start < end) {
                    if (num[start] + num[end] + num[i] + num[j] == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        set.add(list);
                        start++;
                        end--;
                    } else if (num[start] + num[end] + num[i] + + num[j] > target) end--;
                    else start++;
                }
            }
        }
        totalList.addAll(set);
        return totalList;
    }


    //test
    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(num,0));
    }
}
