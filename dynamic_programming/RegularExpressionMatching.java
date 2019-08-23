package dynamic_programming;

public class RegularExpressionMatching {

	public boolean solution(String s, String p) {
		if (s == null || p == null)
			return false;

		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];

		// 1. empty string matches empty string
		dp[0][0] = true;

		// 2. dp[i][0] = false since empty pattern does not match non-empty string

		// 3. pattern #*#*... matches empty string
		// Note that "*" or "a**" is invalid
		for (int j = 2; j <= n; j += 2) {
			dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
		}

		// 4. If p.charAt(j) == s.charAt(i), then dp[i][j] = dp[i-1][j-1]
		// 5. If p.charAt(j) == '.', then dp[i][j] = dp[i-1][j-1]
		// 6. If p.charAt(j) == '*'
		// 6.1 If p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then * is
		// counted as empty. dp[i][j] = dp[i][j - 2]
		// 6.2 If p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)
		// 6.2.1 p.charAt(j - 1) is counted as empty, dp[i][j] = dp[i][j - 2]
		// 6.2.2 p.charAt(j - 1) is counted as one, dp[i][j] = dp[i][j - 1]
		// 6.2.3 p.charAt(j - 1) is counted as multiple, dp[i][j] = dp[i-1][j]
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char charS = s.charAt(i - 1), charP = p.charAt(j - 1);
				if (charS == charP || charP == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else if (charP == '*') {
					char prevP = p.charAt(j - 2);
					if (prevP != '.' && prevP != charS)
						dp[i][j] = dp[i][j - 2];
					else
						dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}

		return dp[m][n];
	}

}
