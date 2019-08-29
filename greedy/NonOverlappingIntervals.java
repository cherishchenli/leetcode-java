package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {

	public int solution(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
		int count = 0, end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= end)
				end = intervals[i][1];
			else
				count++;
		}
		return count;
	}

}
