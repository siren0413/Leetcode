package question;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author siren0413
 * 
 */

public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict){
		boolean[] table = new boolean[s.length()+1]; // add one because first one is redundent;
		table[0] = true;

		for(int i = 0; i < table.length; i++){
			if(table[i]){
				for(int j = i; j < s.length()+1; j++){
					if(dict.contains(s.substring(i,j)))
						table[j] = true;
				}	
			}
		}
		return table[s.length()];
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s,dict));
	}
}
