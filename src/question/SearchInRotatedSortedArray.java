package question;

/**
 * Created by admin on 1/16/14.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] A, int target){
        if(A.length == 0) return 0;
        int start = 0, end = A.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(A[mid] == target) return mid;
            if(A[mid] > A[start] ){
                if(target < A[mid] && target >= A[start])
                    end = mid-1;
                else
                    start = mid+1;
            }else if(A[mid] < A[end]){
                if( target > A[mid] && target <= A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return 0;
    }



    // test
    public static void main(String[] args){
        int[] A = {4,5,6,7,0,1,2};
        System.out.println(search(A,0));
    }


}
