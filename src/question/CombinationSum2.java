package question;

import java.util.*;

/**
 * Created by admin on 1/20/14.
 */
public class CombinationSum2 {
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        Set<ArrayList<Integer>> totalSet = new HashSet<>();
        if (num.length == 0) return totalList;
        ArrayList<Integer> subList = new ArrayList<>();
        Arrays.sort(num);
        combinationSumHelper(num, target, 0, subList, totalSet);
        totalList.addAll(totalSet);
        return totalList;
    }

    static int sum = 0;

    private static void combinationSumHelper(int[] candidates, int target, int i, ArrayList<Integer> subList, Set<ArrayList<Integer>> totalSet) {
        if (sum == target) {
            ArrayList<Integer> copy = new ArrayList<>(subList);
            totalSet.add(copy);
            return;
        }
        if (i > candidates.length - 1) return;

        if (sum + candidates[i] <= target) {
            sum += candidates[i];
            subList.add(candidates[i]);
            combinationSumHelper(candidates, target, i + 1, subList, totalSet);
            subList.remove(subList.size() - 1);
            sum -= candidates[i];
        }
        combinationSumHelper(candidates, target, i + 1, subList, totalSet);

    }


    //test
    public static void main(String[] args) {
        int[] candidates = {1};
        System.out.println(combinationSum2(candidates, 1));
    }
}
