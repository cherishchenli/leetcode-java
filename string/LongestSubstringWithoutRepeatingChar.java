package string;

public class LongestSubstringWithoutRepeatingChar {

	public int solution(String s) {
		int result = 0;
		int[] map = new int[128];
		for (int i = 0, j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			i = Math.max(map[c], i);
			result = Math.max(result, j - i + 1);
			map[c] = j + 1;
		}
		return result;
	}

}
