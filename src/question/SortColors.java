package question;

import java.util.Arrays;

/**
 * Created by admin on 1/17/14.
 */
public class SortColors {

    // two pass
    public static void sortColors(int[] A) {
        int[] colors = new int[3];
        for (int i : A) colors[i]++;
        for (int i = 0; i < A.length; i++) {
            if (colors[0] != 0) {
                A[i] = 0;
                colors[0]--;
            } else if (colors[1] != 0) {
                A[i] = 1;
                colors[1]--;
            } else {
                A[i] = 2;
            }
        }
    }


    // one pass
    public static void sortColors2(int[] A) {
        int i = 0;
        while (i < A.length && A[i] == 0) i++;
        int j = A.length - 1;
        while (j >= 0 && A[j] == 2) j--;
        for (int k = 0; k <= A.length-1; k++) {
            if (A[k] == 0 && k > i) {
                swap(A, k, i++);
                k--;
            }
            else if (A[k] == 2 && k < j) {
                swap(A, k, j--);
                k--;
            }
        }
    }

    private static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }


    //test
    public static void main(String[] args) {
        int[] A = {2};
        sortColors2(A);
        System.out.println(Arrays.toString(A));
    }
}
