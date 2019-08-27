package dynamic_programming;

public class BuyAndSellStockWithCooldown {

	public int solution(int[] prices) {

		if (prices == null || prices.length < 2)
			return 0;

		int max = Math.max(0, prices[1] - prices[0]), prevMax = 0, tmpMax = Math.max(-prices[0], -prices[1]);

		for (int i = 2; i < prices.length; i++) {
			int newMax = Math.max(max, prices[i] + tmpMax);
			tmpMax = Math.max(tmpMax, prevMax - prices[i]);
			prevMax = max;
			max = newMax;
		}

		return max;
	}

}
