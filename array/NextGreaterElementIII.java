package array;

import java.util.Arrays;

public class NextGreaterElementIII {

	public int solution(int n) {
		char[] num = (n + "").toCharArray();

		int i = num.length - 2;
		while (i >= 0 && num[i + 1] <= num[i])
			i--;

		if (i < 0)
			return -1;

		int j = num.length - 1;
		while (j >= i && num[j] <= num[i])
			j--;
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;

		Arrays.sort(num, i + 1, num.length);

		long result = Long.parseLong(new String(num));
		return (result <= Integer.MAX_VALUE) ? (int) result : -1;
	}

}
