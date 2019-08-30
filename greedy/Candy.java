package greedy;

import java.util.Arrays;

public class Candy {

	public int solution1(int[] ratings) {
		int n = ratings.length;
		if (n <= 1)
			return n;

		int[] candies = new int[n];
		Arrays.fill(candies, 1);

		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1])
				candies[i] = candies[i - 1] + 1;
		}

		for (int i = n - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i])
				candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
		}

		int total = 0;
		for (int candy : candies)
			total += candy;

		return total;
	}

	public int solution2(int[] ratings) {
		int n = ratings.length;
		if (n <= 1)
			return n;

		int total = 1, curr = 1, localMax = 1, down = 0;
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				curr++;
				localMax = curr;
				down = 0;
			} else if (ratings[i] == ratings[i - 1]) {
				curr = 1;
				localMax = down = 0;
			} else {
				curr = 1;
				total += down;
				down++;
				if (down >= localMax)
					total += 1;
			}
			total += curr;
		}

		return total;
	}

}
