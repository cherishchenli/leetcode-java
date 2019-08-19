package dynamic_programming;

public class MinCostClimbingStairs {

	public int solution(int[] cost) {
		int total = 0, prev1 = cost[1], prev2 = cost[0];

		for (int i = 2; i < cost.length; i++) {
			total = Math.min(prev1, prev2) + cost[i];
			prev2 = prev1;
			prev1 = total;
		}

		return Math.min(prev1, prev2);
	}

}
