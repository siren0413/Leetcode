package question;

/**
 * Created by admin on 1/16/14.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int curr = A[0];
        int length = A.length;
        int i = 1;
        while (i < length) {
            int scout = i;
            while (scout < length && A[scout] == curr) scout++;
            if(scout!=i && scout!=i+1){
                System.arraycopy(A,scout,A,i+1,length-scout);
                length = length - (scout - (i+1));
            }
            curr = A[i++];
        }
        return length ;
    }


    // test
    public static void main(String[] args){
        int[] A = {1,2,2,2,3,4,4};
        System.out.println(removeDuplicates(A));
    }
}
