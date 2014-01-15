package question;

import java.util.*;

/**
 * Created by admin on 1/15/14.
 */
public class Subsets2 {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        subsetsHelper(num, 0, temp, set);
        list.addAll(set);
        return list;
    }

    private static void subsetsHelper(int[] num, int i, ArrayList<Integer> temp,Set<ArrayList<Integer>> set) {
        if (i >= num.length) {
            ArrayList<Integer> copy = new ArrayList<>(temp);
            Collections.sort(copy);
            set.add(copy);
            return;
        }
        // not choose current S[i]
        subsetsHelper(num, i + 1, temp, set);

        // choose current S[i]
        temp.add(num[i]);
        subsetsHelper(num, i + 1, temp, set);
        temp.remove(temp.size() - 1);
    }




    // test
    public static void main(String[] args) {
        int[] S = {1, 2, 2};
        System.out.println(subsetsWithDup(S));
    }
}
