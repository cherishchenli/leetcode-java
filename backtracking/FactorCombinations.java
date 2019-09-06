package backtracking;

import java.util.*;

public class FactorCombinations {

	public List<List<Integer>> solution(int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (n == 1)
			return result;
		backtrack(n, result, new ArrayList<>(), 2);
		return result;
	}

	private void backtrack(int n, List<List<Integer>> result, List<Integer> list, int start) {
		for (int i = start; i * i <= n; i++) {
			if (n % i != 0)
				continue;
			list.add(i);
			{
				list.add(n / i);
				result.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
			}
			backtrack(n / i, result, list, i);
			list.remove(list.size() - 1);
		}
	}

}
