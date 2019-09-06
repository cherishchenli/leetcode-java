package backtracking;

import java.util.*;

public class LetterCasePermutation {

	/* Backtracking solution */
	public List<String> solution1(String S) {
		List<String> result = new ArrayList<>();
		char[] ca = S.toCharArray();
		backtrack(result, ca, 0);
		return result;
	}

	/* BFS solution */
	public List<String> solution2(String S) {
		LinkedList<String> result = new LinkedList<>();
		result.add(S);
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (Character.isLetter(c))
				for (int size = result.size(); size > 0; size--) {
					String s = result.poll(), left = s.substring(0, i), right = s.substring(i + 1);
					result.add(left + Character.toLowerCase(c) + right);
					result.add(left + Character.toUpperCase(c) + right);
				}
		}
		return result;
	}

	private void backtrack(List<String> result, char[] ca, int i) {
		if (i == ca.length) {
			result.add(new String(ca));
			return;
		}

		char c = ca[i];
		if (Character.isDigit(c)) {
			backtrack(result, ca, i + 1);
		} else {
			ca[i] = Character.toLowerCase(c);
			backtrack(result, ca, i + 1);
			ca[i] = Character.toUpperCase(c);
			backtrack(result, ca, i + 1);
		}
	}

}
