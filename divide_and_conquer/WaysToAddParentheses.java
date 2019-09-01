package divide_and_conquer;

import java.util.*;

public class WaysToAddParentheses {

	private Map<String, List<Integer>> map = new HashMap<>();

	public List<Integer> solution(String input) {
		List<Integer> result = new LinkedList<Integer>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!Character.isDigit(c)) {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				List<Integer> leftResult = map.getOrDefault(left, solution(left));
				List<Integer> rightResult = map.getOrDefault(right, solution(right));
				for (Integer n1 : leftResult) {
					for (Integer n2 : rightResult) {
						switch (c) {
						case '+':
							result.add(n1 + n2);
							break;
						case '-':
							result.add(n1 - n2);
							break;
						case '*':
							result.add(n1 * n2);
							break;
						}
					}
				}
			}
		}

		if (result.size() == 0)
			result.add(Integer.valueOf(input));

		map.put(input, result);
		return result;
	}

}
