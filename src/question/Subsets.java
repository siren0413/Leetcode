package question;

import java.util.*;

/**
 * Created by admin on 1/15/14.
 */
public class Subsets {

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subsetsHelper(S, 0, temp, list);
        return list;
    }

    private static void subsetsHelper(int[] S, int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list) {
        if (i >= S.length) {
            ArrayList<Integer> copy = new ArrayList<>(temp);
            Collections.sort(copy);
            list.add(copy);
            return;
        }
        // not choose current S[i]
        subsetsHelper(S, i + 1, temp, list);

        // choose current S[i]
        temp.add(S[i]);
        subsetsHelper(S, i + 1, temp, list);
        temp.remove(temp.size() - 1);
    }




    // test
    public static void main(String[] args) {
        int[] S = {1, 2, 2};
        System.out.println(subsets(S));
    }

}
