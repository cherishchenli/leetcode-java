package backtracking;

import java.util.*;

public class Combinations {

	public List<List<Integer>> solution(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), n, k, 1);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
		if (list.size() == k) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);
			backtrack(result, list, n, k, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
