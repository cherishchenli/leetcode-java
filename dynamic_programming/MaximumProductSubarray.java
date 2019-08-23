package dynamic_programming;

public class MaximumProductSubarray {

	public int solution(int[] nums) {
		int max = nums[0];

		for (int i = 1, maxNegative = max, maxPositive = max; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = maxNegative;
				maxNegative = maxPositive;
				maxPositive = tmp;
			}

			maxPositive = Math.max(nums[i], nums[i] * maxPositive);
			maxNegative = Math.min(nums[i], nums[i] * maxNegative);

			max = Math.max(max, maxPositive);
		}
		return max;
	}

}
