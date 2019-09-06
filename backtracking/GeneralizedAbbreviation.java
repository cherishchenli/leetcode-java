package backtracking;

import java.util.*;

public class GeneralizedAbbreviation {

	public List<String> solution(String word) {
		List<String> result = new ArrayList<>();
		backtrack(result, "", word, 0, 0);
		return result;
	}

	private void backtrack(List<String> result, String abbr, String word, int i, int count) {
		if (i == word.length()) {
			if (count > 0)
				abbr += count;
			result.add(abbr);
			return;
		}

		backtrack(result, abbr, word, i + 1, count + 1);
		backtrack(result, abbr + (count > 0 ? count : "") + word.charAt(i), word, i + 1, 0);
	}

}
