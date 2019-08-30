package greedy;

import java.util.*;

public class QueueReconstructionByHeight {

	public int[][] solution(int[][] people) {

		Arrays.sort(people, (p1, p2) -> (p1[0] - p2[0] == 0 ? p1[1] - p2[1] : p2[0] - p1[0]));

		List<int[]> result = new LinkedList<>();

		for (int[] person : people) {
			result.add(person[1], person);
		}

		return result.toArray(new int[people.length][]);
	}

}
