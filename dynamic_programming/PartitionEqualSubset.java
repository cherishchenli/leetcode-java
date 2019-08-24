package dynamic_programming;

public class PartitionEqualSubset {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if ((sum & 1) == 1)
			return false;
		sum /= 2;

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int i = 0; i < nums.length; i++) {
			for (int j = sum; j >= nums[i]; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}

		return dp[sum];
	}

}
