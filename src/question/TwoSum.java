package question;

import java.util.*;

/**
 * Created by admin on 1/22/14.
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < numbers.length; i++){
            map.put(numbers[i],i);
        }
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                int index = map.get(target-numbers[i]);
                if(index == i) continue;
                int[] ret = new int[2];
                ret[0] = (i < index? i:index)+1;
                ret[1] = (i < index? index:i)+1;
                return ret;
            }
        }
        return null;
    }


    //test
    public static void main(String[] args) {
        int[] numbers = {3,2,4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
    }

}
