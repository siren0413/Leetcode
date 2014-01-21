package question;

import java.util.*;

/**
 * Created by admin on 1/20/14.
 */
public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if(candidates.length ==0) return totalList;
        ArrayList<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, subList, totalList);
        return totalList;
    }

    static int sum = 0;
    private static void combinationSumHelper(int[] candidates, int target, int i, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> totalList) {
        if (sum == target) {
            ArrayList<Integer> copy = new ArrayList<>(subList);
            totalList.add(copy);
            return;
        }
        if(i > candidates.length-1) return;

        if (sum + candidates[i] <= target) {
            sum += candidates[i];
            subList.add(candidates[i]);
            combinationSumHelper(candidates, target, i, subList, totalList);
            subList.remove(subList.size() - 1);
            sum -= candidates[i];
        }
        combinationSumHelper(candidates, target, i + 1, subList, totalList);

    }



    //test
    public static void main(String[] args) {
        int[] candidates = {1};
        System.out.println(combinationSum(candidates, 1));
    }
}
