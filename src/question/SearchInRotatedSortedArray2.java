package question;

/**
 * Created by admin on 1/16/14.
 */
public class SearchInRotatedSortedArray2 {
    public static boolean search(int[] A, int target){
        if(A.length == 0) return false;
        int start = 0, end = A.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(A[mid] == target) return true;
            if(A[mid] == A[start] && A[mid] == A[end]){
                for(int i = start; i <= end; i++){
                    if(A[i] == target) return true;
                }
                break;
            }
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
        return false;
    }



    // test
    public static void main(String[] args){
        int[] A = {3,1};
        System.out.println(search(A,0));
    }
}
