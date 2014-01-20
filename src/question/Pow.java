package question;

/**
 * Created by admin on 1/19/14.
 */
public class Pow {
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        double k = pow(x, n / 2);
        if (n < 0) return (Math.abs(n % 2) == 1 ? 1 / x : 1) * k * k;
        return (n % 2 == 1 ? x : 1) * k * k;
    }


    // test
    public static void main(String[] args) {
        System.out.println(pow(34.00515, -3));
    }

}
