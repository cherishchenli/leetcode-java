package array;

import java.util.List;
import java.util.ArrayList;

public class FindDuplicatesInArray {

	public List<Integer> solution(int[] nums) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				result.add(index + 1);
			nums[index] = -nums[index];
		}

		return result;
	}

}
