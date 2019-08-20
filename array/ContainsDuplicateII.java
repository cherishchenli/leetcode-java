package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

	public boolean solution(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			if (i > k)
				set.remove(nums[i - k]);
			set.add(nums[i]);
		}
		return false;
	}

}
