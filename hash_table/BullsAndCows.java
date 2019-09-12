package hash_table;

public class BullsAndCows {

	public String solution(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] digits = new int[10];

		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
			if (s == g) {
				bulls++;
			} else {
				digits[s]++;
				digits[g]--;
				if (digits[s] <= 0)
					cows++;
				if (digits[g] >= 0)
					cows++;
			}

		}

		return bulls + "A" + cows + "B";
	}

}
