package backtracking;

import java.util.*;

public class CombinationSumIII {

	public List<List<Integer>> solution(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(k, n, result, new ArrayList<>(), 1);
		return result;
	}

	private void backtrack(int k, int n, List<List<Integer>> result, List<Integer> list, int start) {
		if (k == 0) {
			if (n == 0)
				result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= 9; i++) {
			if (i > n)
				break;
			list.add(i);
			backtrack(k - 1, n - i, result, list, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
