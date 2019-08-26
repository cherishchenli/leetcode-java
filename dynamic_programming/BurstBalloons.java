package dynamic_programming;

public class BurstBalloons {

	public int solution1(int[] nums) {
		int n = nums.length + 2;
		int[] newNums = new int[n];
		for (int i = 1; i < n - 1; i++)
			newNums[i] = nums[i - 1];
		newNums[0] = newNums[n - 1] = 1;

		// dp[i][j]: max number of coins obtained from bursting all the balloons between
		// index i and j (excluding i or j)
		int[][] dp = new int[n][n];
		return helper(dp, newNums, 0, n - 1);
	}

	private int helper(int[][] dp, int[] nums, int left, int right) {
		if (left + 1 == right)
			return 0;
		if (dp[left][right] > 0)
			return dp[left][right];

		int max = 0;
		for (int i = left + 1; i < right; i++) {
			int curr = nums[left] * nums[i] * nums[right];
			curr += helper(dp, nums, left, i);
			curr += helper(dp, nums, i, right);
			max = Math.max(max, curr);
		}
		dp[left][right] = max;
		return max;
	}

	public int solution2(int[] nums) {
		int n = nums.length + 2;
		int[] newNums = new int[n];
		for (int i = 1; i < n - 1; i++)
			newNums[i] = nums[i - 1];
		newNums[0] = newNums[n - 1] = 1;

		int[][] dp = new int[n][n];
		for (int left = n - 2; left >= 0; left--) {
			for (int right = left + 2; right < n; right++) {
				for (int i = left + 1; i < right; i++) {
					dp[left][right] = Math.max(dp[left][right],
							newNums[left] * newNums[i] * newNums[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		return dp[0][n - 1];
	}

}
