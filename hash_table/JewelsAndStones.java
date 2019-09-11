package hash_table;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

	public int solution(String J, String S) {
		Set<Character> set = new HashSet<>();
		for (char j : J.toCharArray())
			set.add(j);
		int count = 0;
		for (char s : S.toCharArray())
			if (set.contains(s))
				count++;
		return count;
	}

}
