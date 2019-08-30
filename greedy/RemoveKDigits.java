package greedy;

import java.util.Stack;

public class RemoveKDigits {

	public String solution(String num, int k) {
		if (num.length() <= k)
			return "0";

		Stack<Character> stack = new Stack<>();
		for (char digit : num.toCharArray()) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
				stack.pop();
				k--;
			}
			stack.push(digit);
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
			sb.deleteCharAt(sb.length() - 1);

		return sb.reverse().toString();
	}
}
