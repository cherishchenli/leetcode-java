package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

	public int[] solution(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length, result[] = new int[n];
		Arrays.fill(result, -1);

		for (int i = 0; i < 2 * n; i++) {
			int j = i % n;
			while (!stack.empty() && nums[stack.peek()] < nums[j])
				result[stack.pop()] = nums[j];
			if (i < n)
				stack.push(j);
		}

		return result;
	}

}
