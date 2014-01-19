package question;

import java.util.*;

/**
 * Created by admin on 1/18/14.
 */
public class EditDistance {


    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] ed = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0){
                    ed[i][j] = j;
                } else if(j == 0){
                    ed[i][j] = i;
                } else {
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        ed[i][j] = ed[i - 1][j - 1];
                    } else {
                        ed[i][j] = 1 + Math.min(ed[i - 1][j - 1], Math.min(ed[i][j - 1], ed[i - 1][j]));
                    }
                }
            }
        }
        return ed[m][n];
    }


    // test
    public static void main(String[] args) {
        String word1 = "hot";
        String word2 = "hige";
        System.out.println(minDistance(word1, word2));
    }

}
