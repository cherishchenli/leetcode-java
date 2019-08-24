package dynamic_programming;

public class EditDistance {

	public int solution(String word1, String word2) {
		if (word1 == null || word1.length() == 0)
			return word2.length();
		if (word2 == null || word2.length() == 0)
			return word1.length();

		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			dp[i][0] = i;
		for (int j = 0; j <= n; j++)
			dp[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
				if (c1 == c2)
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}

		return dp[m][n];
	}

}