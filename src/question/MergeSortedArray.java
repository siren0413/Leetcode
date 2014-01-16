package question;

import java.util.Arrays;

/**
 * Created by admin on 1/15/14.
 */
public class MergeSortedArray {

    // from small to large order
    public static void merge(int[] A, int m, int B[], int n) {
        System.arraycopy(A, 0, A, n, m);
        int i = n;
        int j = 0;
        int index = 0;
        while (i < m + n && j < n)
            A[index++] = A[i] <= B[j] ? A[i++] : B[j++];
        while (j < n)
            A[index++] = B[j++];
    }

    // from large to small order
    public static void merge2(int[] A, int m, int B[], int n) {
        int index = m + n - 1;
        m--; n--;
        while (m >= 0 && n >= 0)
            A[index--] = A[m] >= B[n] ? A[m--] : B[n--];
        while (n >= 0)
            A[index--] = B[n--];
    }



    // test
    public static void main(String[] args) {
        int[] A = {1, 4, 9, 0, 0, 0, 0};
        int[] B = {2, 3, 6, 12};
        merge(A, 3, B, 4);
        System.out.println(Arrays.toString(A));
    }
}
