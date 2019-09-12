package hash_table;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public boolean solution(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern == null || pattern.length() != words.length)
			return false;

		Map map = new HashMap();
		for (Integer i = 0; i < words.length; i++) {
			if (map.put(pattern.charAt(i), i) != map.put(words[i], i))
				return false;
		}
		return true;
	}

}
