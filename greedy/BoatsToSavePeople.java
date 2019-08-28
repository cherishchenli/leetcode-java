package greedy;

import java.util.Arrays;

public class BoatsToSavePeople {

	public int solution(int[] people, int limit) {
		if (people == null || people.length == 0 || limit == 0)
			return 0;

		Arrays.sort(people);
		int count = 0;
		for (int i = 0, j = people.length - 1; j >= i; j--) {
			if (i != j && people[i] + people[j] <= limit)
				i++;
			count++;
		}
		return count;
	}

}
