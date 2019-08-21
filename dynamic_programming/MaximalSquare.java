package dynamic_programming;

public class MaximalSquare {

	public int solution(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length, max = 0, prev = 0;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int tmp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
					max = Math.max(dp[j], max);
				} else
					dp[j] = 0;
				prev = tmp;
			}
		}
		return max * max;
	}

}
