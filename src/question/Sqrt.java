package question;

/**
 * Created by admin on 1/18/14.
 */
public class Sqrt {
    // Newton's method
    public static int sqrt(int x) {
        if (x == 0) return 0;
        double ERROR = 0.1, val = 1, pre = 0;
        while (Math.abs(val - pre) > ERROR) {
            pre = val;
            val = (val + x / val) / 2;
        }
        return (int) val;
    }


    // binary search
    public static int sqrt2(int x) {
        if(x <= 0) return 0;
        if(x == 1) return 1;
        long high = x;
        long low = 0;
        while (Math.abs(high - low) > 1) {
            long mid = (high + low) / 2;
            if (mid * mid > x) high = mid;
            if (mid * mid < x) low = mid;
        }
        return (int)low;
    }


    // test
    public static void main(String[] args) {
        System.out.println(sqrt2(8));
    }
}
