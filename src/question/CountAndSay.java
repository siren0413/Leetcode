package question;

import java.util.*;

/**
 * Created by admin on 1/20/14.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String last = "1";
        while (n-1 > 0) {
            int num = -1;
            int count = 0;
            StringBuilder sub = new StringBuilder();
            for(int i=0; i < last.length(); i++){
                if(num == -1)
                    num = last.charAt(i) - '0';
                if(last.charAt(i)-'0' == num){
                    count++;
                }else{
                    sub.append(count+""+num);
                    num = -1;
                    count = 0;
                    i--;
                }
            }
            if(count!=0)sub.append(count+""+num);
            last = sub.toString();
            n--;
        }
        return last;
    }


    //test
    public static void main(String[] args){
        System.out.println(countAndSay(2));
    }
}
