package question;

/**
 * Created by admin on 1/21/14.
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        long a = (int)Math.abs((double)dividend);
        long b = (int)Math.abs((double)divisor);
        int res = 0;
        while (a >= b) {
            long temp = b;
            for (int i = 0; a >= temp; i++, temp <<= 1) {
                a-=temp;
                res += 1<<i;
            }
        }
        return ((dividend>0 && divisor<0) || (dividend<0 && divisor>0))? (-res): (res);
    }



    // test
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }
}
