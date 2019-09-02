package string;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramsInString {

	public List<Integer> solution(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();

		int[] map = new int[26];
		for (char c : p.toCharArray())
			map[c - 'a']++;

		int left = 0, right = 0, counter = p.length();
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map[c - 'a'] > 0)
				counter--;
			map[c - 'a']--;
			while (counter == 0) {
				char tmp = s.charAt(left);
				if (map[tmp - 'a'] == 0) {
					counter++;
					if (right - left + 1 == p.length())
						result.add(left);
				}
				map[tmp - 'a']++;
				left++;
			}
			right++;
		}

		return result;
	}

}
