package backtracking;

import java.util.*;

public class CombinationSumII {

	public List<List<Integer>> solution(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, result, new ArrayList<>(), 0);
		return result;
	}

	private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int start) {
		if (target == 0)
			result.add(new ArrayList<>(list));

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			if (candidates[i] > target)
				break;
			list.add(candidates[i]);
			backtrack(candidates, target - candidates[i], result, list, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
