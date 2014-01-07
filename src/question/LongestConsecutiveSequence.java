package question;

import java.util.*;

/**
 * Created by siren0413 on 1/6/14.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num){
        if(num == null)
            return 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        for(int i: num){
            set.add(i);
        }

        int max = Integer.MIN_VALUE;
        int temp = 0;
        for(int i: set){
            if(visit.contains(i))
                continue;
            visit.add(i);
            temp++;
            int left = i, right = i;
            while(set.contains(right+1)){
                temp++;
                visit.add(right+1);
                right++;
            }
            while(set.contains(left-1)){
                temp++;
                visit.add(left-1);
                left--;
            }
            if(temp > max)
                max = temp;
            temp = 0;
        }
        return max;
    }

    public static void main(String[] args){
        int[] num = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));
    }


}
