package hash_table;

import java.util.*;

public class KeyboardRow {

	public String[] solution(String[] words) {
		String[] keyboard = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		List<String> result = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < keyboard.length; i++) {
			for (char c : keyboard[i].toCharArray()) {
				map.put(c, i);
			}
		}

		for (String word : words) {
			int row = map.get(word.toLowerCase().charAt(0));
			for (char c : word.toLowerCase().toCharArray()) {
				if (map.get(c) != row) {
					row = -1;
					break;
				}
			}
			if (row != -1)
				result.add(word);
		}

		return result.toArray(new String[0]);
	}

}
