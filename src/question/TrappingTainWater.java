package question;

import java.util.Arrays;

/**
 * Created by admin on 1/20/14.
 */
public class TrappingTainWater {
    public static int trap(int[] A){
        int max = 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for(int i = 0; i < A.length ; i++){
            if(A[i] > max) max = A[i];
            left[i] = max;
        }
        max = 0;
        for(int i = A.length-1; i>=0; i--){
            if(A[i] > max) max = A[i];
            right[i] = max;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum+= Math.min(left[i],right[i]) - A[i];
        }
        return sum;
    }


    //test
    public static void main(String[] args){
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(A));
    }
}
