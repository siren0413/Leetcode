package question;

/**
 * Created by admin on 1/23/14.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return sign * result;
    }


    //test
    public static void main(String[] args){
        System.out.println(reverse(12));
    }
}
