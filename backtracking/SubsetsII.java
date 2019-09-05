package backtracking;

import java.util.*;

public class SubsetsII {

	public List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		result.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			list.add(nums[i]);
			backtrack(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
