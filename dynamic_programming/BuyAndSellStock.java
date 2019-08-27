package dynamic_programming;

public class BuyAndSellStock {

	public int solution(int[] prices) {
		int max = 0, prevMin = Integer.MAX_VALUE;
		for (int price : prices) {
			if (price > prevMin)
				max = Math.max(max, price - prevMin);
			else
				prevMin = price;
		}
		return max;
	}

}
