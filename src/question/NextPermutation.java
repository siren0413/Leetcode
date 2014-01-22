package question;


import java.util.Arrays;

/**
 * Created by admin on 1/21/14.
 */
public class NextPermutation {
    public static void nextPermutation(int[] num) {
        for(int i = num.length-1; i >=1; i--){
            if(num[i]>num[i-1]){
                int j;
                for(j = num.length-1; j >=i-1; j--){
                    if(num[j] > num[i-1])break;
                }
                swap(num,j,i-1);
                reverse(num,i,num.length-1);
                return;
            }
        }
        reverse(num,0,num.length-1);
    }

    private static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    private static void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }



    //test
    public static void main(String[] args) {
        int[] num = {1,4,3,2};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
}
