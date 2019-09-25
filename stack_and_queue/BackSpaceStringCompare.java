package stack_and_queue;

import java.util.Stack;

public class BackSpaceStringCompare {

	public boolean solution1(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		while (i >= 0 || j >= 0) {
			i = backspace(S, i);
			j = backspace(T, j);
			if (i < 0 || j < 0)
				break;
			if (S.charAt(i) != T.charAt(j))
				return false;
			i--;
			j--;
		}
		return i == -1 && j == -1;
	}

	public boolean solution2(String S, String T) {
		return build(S).equals(build(T));
	}

	private String build(String S) {
		Stack<Character> result = new Stack<>();
		for (char c : S.toCharArray()) {
			if (c != '#')
				result.push(c);
			else if (!result.empty())
				result.pop();
		}
		return String.valueOf(result);
	}

	private int backspace(String s, int i) {
		int back = 0;
		while (i >= 0) {
			if (s.charAt(i) == '#')
				back++;
			else if (back > 0)
				back--;
			else
				break;
			i--;
		}
		return i;
	}
}
