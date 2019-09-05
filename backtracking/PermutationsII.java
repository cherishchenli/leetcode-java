package backtracking;

import java.util.*;

public class PermutationsII {

	public List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;
			used[i] = true;
			list.add(nums[i]);
			backtrack(result, list, nums, used);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}

}
