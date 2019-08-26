package dynamic_programming;

import java.util.stream.IntStream;

public class PalindromePartitioningII {

	public int solution(String s) {
		if (s == null || s.length() <= 1)
			return 0;

		int n = s.length();
		// dp[i]: cut number of string s[0, n-1]
		// initialize dp[i] = i
		int[] dp = IntStream.range(0, n).toArray();

		for (int i = 1; i < n; i++) {
			// odd length
			for (int left = i, right = i; left >= 0 && right < n
					&& s.charAt(left) == s.charAt(right); left--, right++) {
				int curr = (left == 0) ? 0 : dp[left - 1] + 1;
				dp[right] = Math.min(dp[right], curr);
			}

			// even length
			for (int left = i - 1, right = i; left >= 0 && right < n
					&& s.charAt(left) == s.charAt(right); left--, right++) {
				int curr = (left == 0) ? 0 : dp[left - 1] + 1;
				dp[right] = Math.min(dp[right], curr);
			}
		}

		return dp[n - 1];
	}

}
