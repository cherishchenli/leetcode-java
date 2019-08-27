package dynamic_programming;

public class BuyAndSellStockIII {

	public int solution(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int dp1 = 0, tmpMax1 = -prices[0];
		int dp2 = 0, tmpMax2 = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp2 = Math.max(dp2, prices[i] + tmpMax2);
			tmpMax2 = Math.max(tmpMax2, dp1 - prices[i]);
			dp1 = Math.max(dp1, prices[i] + tmpMax1);
			tmpMax1 = Math.max(tmpMax1, -prices[i]);
		}

		return dp2;
	}

}
