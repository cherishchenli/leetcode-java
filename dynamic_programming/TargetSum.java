package dynamic_programming;

public class TargetSum {

	public int solution(int[] nums, int target) {

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (target > sum || ((target + sum) & 1) == 1)
			return 0;
		target = (target + sum) / 2;
		int[] dp = new int[target + 1];
		dp[0] = 1;

		for (int i = 0; i < nums.length; i++)
			for (int j = target; j >= nums[i]; j--)
				dp[j] += dp[j - nums[i]];

		return dp[target];
	}

}
