package backtracking;

import java.util.*;

public class GenerateParenthesis {

	public List<String> solution1(int n) {
		// backtracking
		List<String> result = new ArrayList<>();

		backtrack(result, "", 0, 0, n);
		return result;
	}

	private void backtrack(List<String> result, String str, int left, int right, int n) {
		if (str.length() == n * 2) {
			result.add(str);
			return;
		}

		if (left < n)
			backtrack(result, str + "(", left + 1, right, n);

		if (right < left)
			backtrack(result, str + ")", left, right + 1, n);
	}

	public List<String> solution2(int n) {
		// dp solution
		List<String> result = new ArrayList<>();

		if (n == 0)
			result.add("");
		else {
			for (int i = 0; i < n; i++)
				for (String left : solution2(i))
					for (String right : solution2(n - 1 - i))
						result.add("(" + left + ")" + right);
		}
		return result;
	}

}
