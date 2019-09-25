package stack_and_queue;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int solution(String[] tokens) {

		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
				int num1 = stack.pop(), num2 = stack.pop(), num = 0;
				switch (token) {
				case "+":
					num = num1 + num2;
					break;
				case "-":
					num = num2 - num1;
					break;
				case "*":
					num = num1 * num2;
					break;
				case "/":
					num = num2 / num1;
					break;
				default:
					break;
				}
				stack.push(num);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.peek();
	}

}
