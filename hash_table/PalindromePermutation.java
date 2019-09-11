package hash_table;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!set.add(c))
				set.remove(c);
		}
		return set.size() <= 1;
	}

}
