package array;

import java.util.List;
import java.util.ArrayList;

public class FindDisapperedNumberInArray {

	public List<Integer> solution(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] > 0)
				nums[idx] = -nums[idx];
		}
		for (int i = 0; i < n; i++)
			if (nums[i] > 0)
				result.add(i + 1);
		return result;
	}

}
