package divide_and_conquer;

import java.util.Arrays;

public class ReversePairs {

	public int reversePairs(int[] nums) {
		int[] count = new int[1];
		mergeSort(nums, count);
		return count[0];
	}

	private int[] mergeSort(int[] nums, int[] count) {
		int len = nums.length;
		if (len <= 1)
			return nums;

		int[] left = mergeSort(Arrays.copyOfRange(nums, 0, len / 2), count);
		int[] right = mergeSort(Arrays.copyOfRange(nums, len / 2, len), count);

		int i = 0, j = 0, low = 0;
		while (j < right.length) {
			while (low < left.length && left[low] <= 2L * right[j])
				low++;
			count[0] += left.length - low;

			while (i < left.length && left[i] < right[j])
				nums[i + j] = left[i++];
			nums[i + j] = right[j++];
		}

		while (i < left.length)
			nums[i + j] = left[i++];

		return nums;
	}

}
