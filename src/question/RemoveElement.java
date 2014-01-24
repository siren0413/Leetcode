package question;

import java.util.Arrays;

/**
 * Created by admin on 1/22/14.
 */
public class RemoveElement {


    public static int removeElement(int[]A ,int elem){
        int i =0,j=0;
        while(i<A.length){
            if(A[i]!=elem){
                A[j] = A[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public static int removeElement2(int[] A, int elem){
        if(A.length ==0)return 0;
        int start = 0, end = A.length-1;
        while(start < end){
            while(start < A.length-1 && A[start]!=elem) start++;
            while(end >0 && A[end]==elem)end--;
            if(start < end){
                A[start]  = A[end];
                A[end] = elem;
            }
        }
        if(A[start] == elem) return start;
        return start+1;
    }

    //test
    public static void main(String[] args){
        int[] A = {};
        System.out.println(removeElement(A, 5));
        System.out.println(Arrays.toString(A));
    }
}
