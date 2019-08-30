package greedy;

import java.util.PriorityQueue;

public class ReorganizeString {

	public String solution(String S) {
		int n = S.length();
		int[] times = new int[26];
		for (char c : S.toCharArray()) {
			times[c - 'a']++;
			if (times[c - 'a'] > (n + 1) / 2)
				return "";
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]));
		for (int i = 0; i < 26; i++) {
			if (times[i] != 0)
				pq.add(new int[] { i + 'a', times[i] });
		}

		StringBuilder sb = new StringBuilder();
		while (pq.size() >= 2) {
			int[] first = pq.poll(), second = pq.poll();
			sb.append((char) first[0]);
			sb.append((char) second[0]);
			if (--first[1] > 0)
				pq.add(first);
			if (--second[1] > 0)
				pq.add(second);
		}

		if (!pq.isEmpty())
			sb.append((char) pq.poll()[0]);

		return sb.toString();
	}

}
