package string;

public class LongestSubstringKDistinctCharacters {

	public int solution(String s, int k) {
		if (s.length() <= k)
			return s.length();

		int[] map = new int[128];
		int count = k;
		int left = 0, right = 0, result = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			if (map[c] == 0)
				count--;
			map[c]++;

			while (count == -1) {
				map[s.charAt(left)]--;
				if (map[s.charAt(left)] == 0)
					count++;
				left++;
			}
			if (count >= 0 && right - left + 1 > result) {
				result = right - left + 1;
			}
			right++;
		}

		return result;
	}

}
