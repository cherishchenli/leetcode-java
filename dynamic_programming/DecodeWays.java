package dynamic_programming;

public class DecodeWays {

	public int solution(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int prev = 1, curr = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < s.length() && curr != 0; i++) {
			int tmp = curr;
			if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
				if (s.charAt(i) == '0')
					curr = prev;
				else
					curr += prev;
			} else if (s.charAt(i) == '0') {
				curr = 0;
			}
			prev = tmp;

		}
		return curr;
	}

}
