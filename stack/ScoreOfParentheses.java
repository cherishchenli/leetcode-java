package stack;

import java.util.Stack;

public class ScoreOfParentheses {

	public int solution1(String S) {
		// solution 1: Stack
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for (char c : S.toCharArray()) {
			if (c == '(') {
				stack.push(result);
				result = 0;
			} else {
				result = stack.pop() + (result == 0 ? 1 : result * 2);
			}
		}
		return result;
	}

	public int solution2(String S) {
		// solution 2: represent stack with array
		int result[] = new int[30], layer = 0;
		for (char c : S.toCharArray()) {
			if (c == '(') {
				layer++;
				result[layer] = 0;
			} else {
				result[layer - 1] += result[layer] == 0 ? 1 : result[layer] * 2;
				layer--;
			}
		}
		return result[0];
	}

	public int solution3(String S) {
		// solution 3: count layers
		int result = 0, layer = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(')
				layer++;
			else
				layer--;
			if (S.charAt(i) == ')' && S.charAt(i - 1) == '(')
				result += 1 << layer;
		}
		return result;
	}

}
