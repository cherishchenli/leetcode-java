package backtracking;

import java.util.*;

public class WordLadderII {

	private Map<String, Set<String>> neighbors = new HashMap<>();
	private Map<String, Integer> distance = new HashMap<String, Integer>();

	public List<List<String>> solution(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		Set<String> wordSet = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		int len = beginWord.length();

		if (!wordSet.contains(endWord))
			return result;

		// find neighbors
		wordSet.add(beginWord);
		for (String word : wordSet) {
			Set<String> set = new HashSet<>();
			for (int i = 0; i < len; i++) {
				char[] charArray = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (word.charAt(i) == c)
						continue;
					charArray[i] = c;
					String transformed = String.valueOf(charArray);
					if (wordSet.contains(transformed))
						set.add(transformed);
				}
			}
			neighbors.put(word, set);
		}

		// calculate distances
		queue.offer(beginWord);
		distance.put(beginWord, 0);
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			int currDist = distance.get(curr);
			for (String next : neighbors.get(curr)) {
				if (distance.containsKey(next))
					distance.put(next, Math.min(distance.get(next), currDist + 1));
				else {
					distance.put(next, currDist + 1);
					queue.offer(next);
				}
			}
		}

		// backtrack
		backtrack(result, new ArrayList<>(), beginWord, endWord);
		return result;
	}

	private void backtrack(List<List<String>> result, List<String> list, String currWord, String endWord) {
		list.add(currWord);

		if (currWord.equals(endWord)) {
			result.add(new ArrayList<>(list));
		} else {
			for (String next : neighbors.get(currWord))
				if (distance.get(next) == distance.get(currWord) + 1)
					backtrack(result, list, next, endWord);
		}

		list.remove(list.size() - 1);
	}

}
