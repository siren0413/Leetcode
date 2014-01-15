package question;

import java.util.*;

/**
 * Created by admin on 1/15/14.
 */
public class RestoreIPAddresses {

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        if (s.length() < 4 || s.length() >12) return list;  // to avoid time limit exceed
        restoreIpAddressesHelper(s, temp, 4, 0, list);
        return list;
    }

    private static void restoreIpAddressesHelper(String s, ArrayList<String> temp, int res, int start, ArrayList<String> list) {
        if (start == s.length()) {
            if (res == 0) {
                String str = "";
                str += temp.get(0) + ".";
                str += temp.get(1) + ".";
                str += temp.get(2) + ".";
                str += temp.get(3);
                list.add(str);

            }
            return;
        }

        if (start + 1 <= s.length()) {
            temp.add(s.substring(start, start + 1));
            restoreIpAddressesHelper(s, temp, res - 1, start + 1, list);
            temp.remove(temp.size() - 1);
        }

        if (start + 2 <= s.length() && s.charAt(start) != '0') {
            temp.add(s.substring(start, start + 2));
            restoreIpAddressesHelper(s, temp, res - 1, start + 2, list);
            temp.remove(temp.size() - 1);
        }

        if (start + 3 <= s.length() && s.charAt(start) != '0' && Integer.valueOf(s.substring(start, start + 3)) <= 255) {
            temp.add(s.substring(start, start + 3));
            restoreIpAddressesHelper(s, temp, res - 1, start + 3, list);
            temp.remove(temp.size() - 1);
        }

    }


    public static void main(String[] args) {
        ArrayList<String> list = restoreIpAddresses("0000");
        System.out.println(list);
    }

}
