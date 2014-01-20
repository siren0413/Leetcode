package question;

/**
 * Created by admin on 1/19/14.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] A){
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < A.length; i++){
            temp += A[i];
            if(temp > max) max = temp;
            if(temp < 0) temp = 0;
        }
        return max;
    }


    // test
    public static void main(String[] args){
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(A));
    }
}
