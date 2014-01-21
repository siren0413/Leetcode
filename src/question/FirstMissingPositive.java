package question;

/**
 * Created by admin on 1/20/14.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        if(A.length==0) return 1;
        for(int i = 0 ; i < A.length;i++){
            while(A[i] > 0 && A[i] < A.length && A[i]!=i+1 && A[A[i]-1]!=A[i]){
                swap(A,i,A[i]-1);
            }
        }
        for(int i = 0; i < A.length;i++){
            if(A[i]!=i+1) return i+1;
        }
        return A[A.length-1]+1;  // last number
    }
    private static void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a]= A[b];
        A[b] = temp;
    }



    //test
    public static void main(String[] args) {
        int[] A = {1};
        System.out.println(firstMissingPositive(A));
    }

}
