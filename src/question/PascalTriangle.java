package question;

import java.util.ArrayList;

/**
 * Created by admin on 1/11/14.
 */
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return list;
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(i + 1);
            if (i == 0) {
                row.add(1);
            } else {
                ArrayList<Integer> upper = list.get(i - 1);
                for (int j = 0; j < upper.size() + 1; j++) {
                    if (j == 0 || j == upper.size())
                        row.add(1);
                    else
                        row.add(upper.get(j - 1) + upper.get(j));
                }
            }
            list.add(row);

        }
        return list;
    }

}
