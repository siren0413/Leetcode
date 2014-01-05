package question;

/**
 * Created by siren0413 on 1/4/14.
 */
public class Candy {

    public static int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;

        // initialize array store candies.
        int[] candy = new int[ratings.length];

        // iterator from left to right, if right one is greater than left one, right = Max(right, left +1).
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1])
                candy[i + 1] = Math.max(candy[i] + 1, candy[i + 1]);
        }

        // iterator from right to left, if left one is greater than right one, left = Max(left, right + 1).
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i] < ratings[i - 1])
                candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
        }

        // sum up candies of all children.
        int sum = ratings.length;
        for (int c : candy) {
            sum += c;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 4, 3, 2, 1, 0, 4, 7, 1};
        //int[] ratings = {0};
        System.out.println(candy(ratings));
    }


}
