package dynamic_programming;

public class WildcardMatching {

	public boolean solution(String s, String p) {
		if (s == null || p == null)
			return false;

		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];

		dp[0][0] = true;
		for (int j = 1; j <= p.length() && p.charAt(j - 1) == '*'; j++)
			dp[0][j] = true;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char charP = p.charAt(j - 1);
				if (s.charAt(i - 1) == charP || charP == '?')
					dp[i][j] = dp[i - 1][j - 1];
				else if (charP == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
			}
		}

		return dp[m][n];
	}

}
