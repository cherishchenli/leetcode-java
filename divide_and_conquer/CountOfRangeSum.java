package divide_and_conquer;

import java.util.Arrays;

public class CountOfRangeSum {

	public int solution(int[] nums, int lower, int upper) {
		int n = nums.length;
		long[] sums = new long[n + 1];
		for (int i = 1; i <= n; i++)
			sums[i] = sums[i - 1] + nums[i - 1];

		int[] count = new int[1];
		mergeSort(sums, count, lower, upper);
		return count[0];
	}

	private long[] mergeSort(long[] sums, int[] count, int lower, int upper) {
		int len = sums.length;
		if (len <= 1)
			return sums;

		long[] left = mergeSort(Arrays.copyOfRange(sums, 0, len / 2), count, lower, upper);
		long[] right = mergeSort(Arrays.copyOfRange(sums, len / 2, len), count, lower, upper);

		int i = 0, j = 0, low = 0, high = 0;
		while (i < left.length) {
			while (low < right.length && right[low] - left[i] < lower)
				low++;
			while (high < right.length && right[high] - left[i] <= upper)
				high++;
			count[0] += high - low;

			while (j < right.length && right[j] < left[i])
				sums[i + j] = right[j++];
			sums[i + j] = left[i++];
		}

		while (j < right.length)
			sums[i + j] = right[j++];

		return sums;
	}

}
