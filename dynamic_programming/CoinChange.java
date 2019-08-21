package dynamic_programming;

public class CoinChange {

	public int solution(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {
			dp[i] = -1;
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != -1) {
					int tmp = dp[i - coin] + 1;
					dp[i] = dp[i] < 0 ? tmp : Math.min(dp[i], tmp);
				}
			}
		}

		return dp[amount];
	}

}
