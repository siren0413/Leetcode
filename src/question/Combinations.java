package question;

import java.util.*;

/**
 * Created by admin on 1/17/14.
 */
public class Combinations {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k){
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if(k ==0 || n==0) return totalList;
        int[] A = new int[n];
        for(int i = 1 ; i <= n; i++) A[i-1] = i;

        combineHelper(A,k,0,subList,totalList);
        return totalList;
    }

    private static void combineHelper(int[] A, int k, int i, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> totalList){
        if(k == 0){
            ArrayList<Integer> copy = new ArrayList<>(subList);
            totalList.add(copy);
            return;
        }
        if( i >= A.length) return;

        combineHelper(A,k,i+1,subList,totalList); // not choose

        subList.add(A[i]);
        combineHelper(A,k-1,i+1,subList,totalList); // choose
        subList.remove(subList.size()-1);
    }




    // test
    public static void main(String[] args){
        System.out.println(combine(4,2));
    }

}
