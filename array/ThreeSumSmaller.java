package array;

import java.util.Arrays;

public class ThreeSumSmaller {

	public int solution(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0, n = nums.length;

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1, right = n - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] >= target) {
					right--;
				} else {
					result += right - left;
					left++;
				}
			}
		}

		return result;
	}

}
