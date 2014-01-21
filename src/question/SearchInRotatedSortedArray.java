package question;

/**
 * Created by admin on 1/16/14.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] A, int target){
        if(A.length == 0) return -1;
        int start = 0, end = A.length-1;
        while(start <= end){
            if(start == end){
                if(target== A[start])return start;
                return -1;
            }
            int mid = (start+end)/2;
            if(A[mid] == target) return mid;
            if(A[mid] >= A[start] ){
                if(target < A[mid] && target >= A[start])
                    end = mid-1;
                else
                    start = mid+1;
            }else if(A[mid] <= A[end]){
                if( target > A[mid] && target <= A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }



    // test
    public static void main(String[] args){
        int[] A = {1};
        System.out.println(search(A,0));
    }


}
