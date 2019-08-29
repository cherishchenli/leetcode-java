package greedy;

import java.util.Arrays;

public class ArrowsToBurstBalloons {

	public int solution(int[][] points) {
		if (points == null || points.length == 0)
			return 0;

		Arrays.sort(points, (x, y) -> x[1] - y[1]);
		int end = points[0][1];
		int count = 1;
		for (int i = 1; i < points.length; i++) {
			if (end < points[i][0]) {
				count++;
				end = points[i][1];
			}
		}
		return count;
	}

}
