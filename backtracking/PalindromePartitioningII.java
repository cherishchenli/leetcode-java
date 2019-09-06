package backtracking;

import java.util.*;

public class PalindromePartitioningII {

	private int[] freq = new int[256];

	public List<String> solution(String s) {
		List<String> result = new ArrayList<>();

		for (char c : s.toCharArray())
			freq[c]++;

		int odd = 0;
		char oddChar = 'a';
		for (int i = 0; i < 256; i++) {
			if ((freq[i] & 1) == 1) {
				odd++;
				oddChar = (char) i;
			}
		}

		if (odd == 0)
			backtrack(result, "", s.length());
		else if (odd == 1)
			backtrack(result, "" + oddChar, s.length());

		return result;
	}

	private void backtrack(List<String> result, String curr, int len) {
		if (curr.length() == len)
			result.add(curr);

		for (int i = 0; i < 256; i++) {
			if (freq[i] <= 1)
				continue;
			freq[i] -= 2;
			backtrack(result, (char) i + curr + (char) i, len);
			freq[i] += 2;
		}
	}

}
