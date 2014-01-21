package question;

import java.util.Arrays;

/**
 * Created by admin on 1/20/14.
 */
public class SearchForARange {
    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (A.length == 0) return result;

        int right = searchBoundry(A, target,false);
        int left = searchBoundry(A, target, true);

        if (left == -1 || right == -1) return result;     // can not find this value
        result[0] = left;
        result[1] = right;

        return result;
    }

    private static int searchBoundry(int[] A, int target, boolean left) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            if (start == end){
                if(A[start] == target) return start;
                return -1;
            }
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                if (left) {
                    if (mid - 1 >= 0 && A[mid - 1] == A[mid]) end = mid - 1;
                    else return mid;
                }else{
                    if (mid + 1 < A.length && A[mid + 1] == A[mid]) start = mid + 1;
                    else return mid;
                }
            }
            else if (target < A[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }


    // test
    public static void main(String[] args) {
        int[] A = {1,1,2};
        System.out.println(Arrays.toString(searchRange(A, 1)));
    }
}
