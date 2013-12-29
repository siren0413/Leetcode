package question;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author siren0413
 * 
 */

public class WordBreak2 {
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<>();
		helper(s, dict, "", result);
		return result;
	}

	private static void helper(String s, Set<String> dict, String temp,
			ArrayList<String> result) {
		if (s == null || s.equals("")) {
			result.add(temp.trim());
			return;
		}
		for (int i = 0; i <= s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				String sub = temp + s.substring(0, i) + " ";
				helper(s.substring(i, s.length()), dict, sub, result);
			}
		}
	}

	public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
		ArrayList<ArrayList<Integer>> table = new ArrayList<>();
		for (int i = 0; i <= s.length(); i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			if (dict.contains(s.substring(0, i)))
				arr.add(0);
			table.add(arr);
		}

		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).isEmpty())
				continue;
			for (int j = i; j <= s.length(); j++) {
				if (dict.contains(s.substring(i, j))) {
					table.get(j).add(i);
				}
			}
		}
		ArrayList<String> result = new ArrayList<>();
		helper2(s.length(), table, result, "", s);
		return result;
	}

	private static void helper2(int index, ArrayList<ArrayList<Integer>> table,
			ArrayList<String> result, String temp, String s) {
		if (index == 0) {
			result.add(temp.trim());
			return;
		}
		ArrayList<Integer> arr = table.get(index);
		for (int i = 0; i < arr.size(); i++) {
			int pre = arr.get(i);
			String sub = s.substring(pre, index) + " " + temp;
			helper2(pre, table, result, sub, s);
		}
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		System.out.println(wordBreak2(s, dict));
	}
}
