package hash_table;

import java.util.*;

public class ShortestWordDistanceII {

	private HashMap<String, List<Integer>> map;

	public ShortestWordDistanceII(String[] words) {
		map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			List<Integer> list = map.getOrDefault(word, new LinkedList<Integer>());
			list.add(i);
			map.put(word, list);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);

		int i = 0, j = 0, min = Integer.MAX_VALUE;
		while (i < list1.size() && j < list2.size()) {
			int idx1 = list1.get(i), idx2 = list2.get(j);
			min = Math.min(min, Math.abs(idx1 - idx2));
			if (idx1 < idx2)
				i++;
			else
				j++;
		}

		return min;
	}

}
