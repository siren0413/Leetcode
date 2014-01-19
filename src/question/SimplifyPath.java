package question;

import java.util.*;

/**
 * Created by admin on 1/18/14.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        String[] split = path.split("/");
        for (String a : split) {
            if (!a.equals(".") && !a.isEmpty()) {
                if (a.equals("..")) {
                    if (!s.isEmpty()) {
                        s.pop();
                    }
                } else {
                    s.push(a);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
            sb.insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }


    // test
    public static void main(String[] args){
        String path = "/a/./b/../../c/";
        String path2 = "/abc/...";
        System.out.println(simplifyPath(path2));
    }

}
