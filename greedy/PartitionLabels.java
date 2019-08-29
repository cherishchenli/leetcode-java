package greedy;

import java.util.*;

public class PartitionLabels {

	public List<Integer> solution(String S) {
		List<Integer> result = new ArrayList<>();

		int[] map = new int[26];
		for (int i = 0; i < S.length(); i++) {
			map[S.charAt(i) - 'a'] = i;
		}

		for (int i = 0, start = 0, end = 0; i < S.length(); i++) {
			end = Math.max(end, map[S.charAt(i) - 'a']);
			if (i == end) {
				result.add(end - start + 1);
				start = i + 1;
			}
		}

		return result;
	}

}
