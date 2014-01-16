package question;

import java.util.*;

/**
 * Created by admin on 1/15/14.
 */
public class GrayCode {

    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < Math.pow(2,n); i++)
            list.add(binaryToGray(i));
        return list;
    }

    private static int binaryToGray(int b) {
        return (b >> 1) ^ b;
    }



    //test
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
}
