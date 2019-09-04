package backtracking;

import java.util.*;

public class LetterCombinationOfPhoneNumber {

	private String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> solution1(String digits) {
		// DFS backtracking
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return result;
		backtrack(result, "", digits);
		return result;
	}

	private void backtrack(List<String> result, String str, String digits) {
		int i = str.length();
		if (i >= digits.length()) {
			result.add(str);
			return;
		}
		int digit = digits.charAt(i) - '0';
		for (char c : mapping[digit].toCharArray())
			backtrack(result, str + c, digits);
	}

	public List<String> solution2(String digits) {
		// BFS
		LinkedList<String> result = new LinkedList<>();
		if (digits.isEmpty())
			return result;
		String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");
		while (result.peek().length() != digits.length()) {
			String prefix = result.remove();
			char[] chars = mapping[digits.charAt(prefix.length()) - '0'].toCharArray();
			for (char c : chars)
				result.addLast(prefix + c);
		}
		return result;
	}

}
