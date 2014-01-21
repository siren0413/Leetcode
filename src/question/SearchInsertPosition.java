package question;

/**
 * Created by admin on 1/20/14.
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            if (start == end) {
                if (A[start] == target) return start;
                else break;
            }
            int mid = (start + end) / 2;
            if (A[mid] == target) return mid;
            if (A[mid] > target)
                end = mid - 1;
            else if (A[mid] < target)
                start = mid + 1;
        }
        if (A[start] > target) return start;
        else return start + 1;
    }


    // test
    public static void main(String[] args){
        int[] A = {1,3,5,6};
        System.out.println(searchInsert(A,7));
    }

}
