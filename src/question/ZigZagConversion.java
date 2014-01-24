package question;

import java.util.*;

/**
 * Created by admin on 1/23/14.
 */
public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        if (nRows == 1) return s;
        int k = nRows * 2 - 2, count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            list.add(i);
            i += k;
        }
        while (count < nRows) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) + count < s.length())
                    sb.append(s.charAt(list.get(j) + count));
                if (count != 0 && count != nRows - 1 && list.get(j) + k - count < s.length()) {
                    sb.append(s.charAt(list.get(j) + k - count));
                }
            }
            count++;
        }

        return sb.toString();
    }



    //test
    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }
}
