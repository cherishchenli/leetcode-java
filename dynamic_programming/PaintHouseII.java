package dynamic_programming;

public class PaintHouseII {

	public int solution(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int min1, min2, min1Idx;
		int prevMin1 = 0, prevMin2 = 0, prevMin1Idx = -1;

		for (int i = 0; i < costs.length; i++) {
			min1 = Integer.MAX_VALUE;
			min2 = Integer.MAX_VALUE;
			min1Idx = -1;

			for (int j = 0; j < costs[0].length; j++) {
				int currCost = costs[i][j];

				if (j == prevMin1Idx)
					currCost += prevMin2;
				else
					currCost += prevMin1;

				if (currCost < min1) {
					if (min1Idx >= 0)
						min2 = min1;
					min1 = currCost;
					min1Idx = j;
				} else if (currCost < min2) {
					min2 = currCost;
				}
			}

			prevMin1 = min1;
			prevMin2 = min2;
			prevMin1Idx = min1Idx;
		}

		return prevMin1;
	}

}
