package question;

/**
 * Created by admin on 1/23/14.
 */
public class StringToInteger {
    // straight forward method
    public static int atoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        StringBuilder sb = new StringBuilder(str);
        long result = 0, k = 1;
        boolean positive = true;

        // remove sign
        if (sb.charAt(0) == '-') {
            positive = false;
            sb.deleteCharAt(0);
        } else if (sb.charAt(0) == '+') {
            positive = true;
            sb.deleteCharAt(0);
        }

        // calculate value
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) > '9' || sb.charAt(i) < '0') {
                result = 0;
                k = 1;
                continue;
            }
            result += (sb.charAt(i) - '0') * k;
            k *= 10;
        }

        // handle overflow
        if (result > Integer.MAX_VALUE) return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) (positive ? (result) : (-result));
    }

    // more smart method
    public static int atoi2(String str) {
        int result = 0, sign = 1, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (str.charAt(i) == '+') i++;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < str.length()) {
            if (str.charAt(i) == ' ') break;
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + str.charAt(i) - '0';
        }
        return result * sign;
    }


    //test
    public static void main(String[] args) {
        System.out.println(atoi2("    10522545459"));
    }
}
