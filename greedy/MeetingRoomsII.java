package greedy;

import java.util.Arrays;

public class MeetingRoomsII {

	public int solution(int[][] intervals) {
		int n = intervals.length;
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		int count = 0, endIdx = 0;
		for (int i = 0; i < n; i++) {
			if (starts[i] < ends[endIdx])
				count++;
			else
				endIdx++;
		}

		return count;
	}

}
