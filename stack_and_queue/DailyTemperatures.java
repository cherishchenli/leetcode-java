package stack_and_queue;

import java.util.Stack;

public class DailyTemperatures {

	public int[] solution(int[] T) {
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int j = stack.pop();
				result[j] = i - j;
			}
			stack.push(i);
		}
		return result;
	}

}
