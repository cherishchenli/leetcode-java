package dynamic_programming;

public class PaintHouse {

	public int solution(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int costR = costs[0][0], costG = costs[0][1], costB = costs[0][2];

		for (int i = 1; i < costs.length; i++) {
			int prevR = costR, prevG = costG, prevB = costB;
			costR = costs[i][0] + Math.min(prevG, prevB);
			costG = costs[i][1] + Math.min(prevR, prevB);
			costB = costs[i][2] + Math.min(prevG, prevR);
		}

		return Math.min(Math.min(costR, costG), costB);
	}

}
