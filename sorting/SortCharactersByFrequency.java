package sorting;

import java.util.*;

public class SortCharactersByFrequency {

	public String solution(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		List<Character>[] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--) {
			if (bucket[pos] != null) {
				for (char num : bucket[pos]) {
					for (int i = 0; i < pos; i++) {
						sb.append(num);
					}
				}
			}
		}
		return sb.toString();
	}

}
