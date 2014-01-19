package question;

/**
 * Created by admin on 1/18/14.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int ci, cj;
            if (i < 0) ci = 0;
            else ci = a.charAt(i) == '0' ? 0 : 1;
            if (j < 0) cj = 0;
            else cj = b.charAt(j) == '0' ? 0 : 1;
            sb.insert(0, (ci + cj + carry) % 2); // get this bit value.
            carry = (ci + cj + carry >= 2) ? 1 : 0; // get new carry value.
            i--;
            j--;
        }
        if (carry == 1) sb.insert(0, 1);
        return sb.toString();
    }


    //test
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
