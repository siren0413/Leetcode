package question;

import java.util.Arrays;

/**
 * Created by admin on 1/18/14.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits){
        int carry = 1;
        for(int i = digits.length-1; i>=0 ;i--){
            if(digits[i] + carry >= 10) {
                digits[i] = 0;
                carry  = 1;
            }else{
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }
        // still have a carry left, means digits length is not enough.
        if(carry == 1){
            int[] copy = new int[digits.length+1];
            copy[0] = 1;
            for(int i = 1; i < digits.length; i++) copy[i] = digits[i-1];
            digits = copy;
        }
        return digits;
    }


    // test
    public static void main(String[] args){
        int[] digits = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
