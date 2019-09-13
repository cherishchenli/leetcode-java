package hash_table;

import java.util.*;

public class GroupAnagrams {

	public List<List<String>> solution(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();

		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String code = encode(s);
			List<String> list = map.getOrDefault(code, new ArrayList<String>());
			list.add(s);
			map.put(code, list);
		}
		return new ArrayList<List<String>>(map.values());
	}

	private String encode(String str) {
		int[] tmp = new int[26];
		for (char c : str.toCharArray())
			tmp[c - 'a']++;
		return Arrays.toString(tmp);
	}

}
