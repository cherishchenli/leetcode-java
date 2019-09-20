package stack_and_queue;

import java.util.Stack;

public class BasicCalculator {

	public int solution(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0, sign = 1, num = 0;
		char[] ca = s.toCharArray();

		for (int i = 0; i < ca.length; i++) {
			char c = ca[i];
			if (Character.isDigit(c)) {
				num = 10 * num + (int) (c - '0');
			} else if (c == '+') {
				result += sign * num;
				num = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * num;
				num = 0;
				sign = -1;
			} else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * num;
				num = 0;
				result *= stack.pop();
				result += stack.pop();
			}
		}
		if (num != 0)
			result += sign * num;
		return result;
	}

}
