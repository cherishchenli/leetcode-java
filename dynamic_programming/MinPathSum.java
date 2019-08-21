package dynamic_programming;

public class MinPathSum {
	public int solution(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] dp = new int[n];

		for (int i = 0; i < m; i++) {
			dp[0] += grid[i][0];
			for (int j = 1; j < n; j++) {
				if (i == 0)
					dp[j] = grid[i][j] + dp[j - 1];
				else
					dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
			}
		}

		return dp[n - 1];
	}
}
