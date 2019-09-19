package stack;

import java.util.Stack;

public class DecodeString {

	public String solution(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		int num = 0;
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			} else if (Character.isLetter(c)) {
				result += c;
			} else if (c == '[') {
				numStack.push(num);
				num = 0;
				strStack.push(result);
				result = "";
			} else {
				int times = numStack.pop();
				StringBuilder tmp = new StringBuilder(strStack.pop());
				for (int j = 0; j < times; j++)
					tmp.append(result);
				result = tmp.toString();
			}
		}

		return result;
	}

}
