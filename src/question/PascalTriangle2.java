package question;

import java.util.ArrayList;

/**
 * Created by admin on 1/11/14.
 */
public class PascalTriangle2 {
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            int pre = 1;
            for (int j = 1; j <= i - 1; j++) {
                int temp = list.get(j);
                list.set(j, pre + temp);
                pre = temp;
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

}
