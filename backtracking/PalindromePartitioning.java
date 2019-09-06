package backtracking;

import java.util.*;

public class PalindromePartitioning {

	public List<List<String>> solution(String s) {
		List<List<String>> result = new ArrayList<>();
		backtrack(s, result, new ArrayList<>(), 0);
		return result;
	}

	private void backtrack(String s, List<List<String>> result, List<String> list, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			if (isPalindrome(sub)) {
				list.add(sub);
				backtrack(s, result, list, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right)
			if (s.charAt(left++) != s.charAt(right--))
				return false;
		return true;
	}

}
