package greedy;

import java.util.Arrays;

public class TaskScheduler {

	public int solution(char[] tasks, int n) {
		int[] sortedTasks = new int[26];
		for (char task : tasks)
			sortedTasks[task - 'A']++;
		Arrays.sort(sortedTasks);
		int i = 25;
		while (i >= 0 && sortedTasks[i] == sortedTasks[25])
			i--;

		return Math.max(tasks.length, (sortedTasks[25] - 1) * (n + 1) + 25 - i);
	}

}
