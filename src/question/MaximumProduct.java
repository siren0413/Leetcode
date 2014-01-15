package question;

/**
 * Created by admin on 1/15/14.
 */
public class MaximumProduct {
    static int max = 0, product = 1, temp = 1, start = 0, end = 0;

    public static int maxProduct(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                product *= arr[i];
                end++;
            }
            if (arr[i] == 0 && product > 0) {
                if (product > max) max = product;
                product = 1;
                temp = 1;
                start = i + 1;
                end = i + 1;
            }
            if (arr[i] == 0 && product < 0) {
                getSubProduct(arr);
                getSubProduct2(arr);
                product = 1;
                temp = 1;
                start = i + 1;
                end = i + 1;
            }
            if (product > max) max = product;
        }
        if (end == 0) end = arr.length;
        if (product < 0) {
            getSubProduct(arr);
            getSubProduct2(arr);
        }
        return max;
    }

    public static int maxProduct2(int[] A) {

        // positive = only product from positive array, negative = product from whole array
        int max = 0, positive = 1, negative = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0){
                positive = 1; negative = 1;
                continue;
            }
            if(A[i] < 0)
                positive = 1;
            else
                positive *= A[i];
            negative *= A[i];
            if (positive > max) max = positive;
            if( negative > max) max = negative;
        }

        // in case odd number of negative values, and last negative value is huge.
        negative = 1;
        for(int i = A.length-1; i>=0; i--){
            negative *= A[i];
            if(negative > max) max = negative;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 0, -6, -4, 1, -56};
        System.out.println(maxProduct2(arr));
    }


    private static void getSubProduct2(int[] arr) {
        for (int j = end - 1; j >= start; j--) {
            temp *= arr[j];
            if (temp < 0) {
                if (product / temp > max) max = product / temp;
                if (temp / arr[j] > max) max = temp / arr[j];
                temp = 1;
                break;
            }
        }
    }

    private static void getSubProduct(int[] arr) {
        for (int j = start; j < end; j++) {
            temp *= arr[j];
            if (temp < 0) {
                if (product / temp > max) max = product / temp;
                if (temp / arr[j] > max) max = temp / arr[j];
                temp = 1;
                break;
            }
        }
    }


}
