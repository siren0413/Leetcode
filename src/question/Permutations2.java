package question;

import java.util.*;

/**
 * Created by admin on 1/20/14.
 */
public class Permutations2 {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (num.length == 0) return totalList;
        permuteHelper(num, 0, totalList);
        return totalList;
    }

    private static void permuteHelper(int[] num, int i, ArrayList<ArrayList<Integer>> list) {
        if (i == num.length) {
            ArrayList<Integer> copy = new ArrayList<>();
            for (int n : num) copy.add(n);
            list.add(copy);
            return;
        }
        for (int j = i; j < num.length; j++) {
            boolean flag = false;
            for(int k = i ; k < j;k++){
                if(num[k] == num[j]) flag = true;       // if already exist duplicate value before j, don't swap again.
            }
            if(flag) continue;

            swap(num, i, j);
            permuteHelper(num, i + 1, list);
            swap(num, i, j);
        }
    }

    private static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }


    // test
    public static void main(String[] args) {
        int[] num = {1, 2, 2};
        System.out.println(permuteUnique(num));
    }
}
