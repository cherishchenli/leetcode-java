package greedy;

import java.util.Stack;

public class RemoveDuplicateLetters {

	public String solution1(String s) {
		int[] count = new int[26];

		for (char c : s.toCharArray())
			count[c - 'a']++;

		boolean[] visited = new boolean[26];
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			count[c - 'a']--;
			if (visited[c - 'a'])
				continue;
			while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] != 0)
				visited[stack.pop() - 'a'] = false;
			stack.push(c);
			visited[c - 'a'] = true;
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
			result.append(stack.pop());

		return result.reverse().toString();
	}

	public String solution2(String s) {
		int[] count = new int[26];

		for (char c : s.toCharArray())
			count[c - 'a']++;

		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos))
				pos = i;
			if (--count[s.charAt(i) - 'a'] == 0)
				break;
		}

		return s.length() == 0 ? ""
				: s.charAt(pos) + solution2(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

}
