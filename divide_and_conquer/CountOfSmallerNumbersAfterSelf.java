package divide_and_conquer;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {

	class Pair {
		int idx, val;

		public Pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public List<Integer> solution(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<>();

		int n = nums.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++)
			pairs[i] = new Pair(i, nums[i]);

		Integer[] smaller = new Integer[n];
		Arrays.fill(smaller, 0);
		mergeSort(pairs, smaller);
		return Arrays.asList(smaller);
	}

	private Pair[] mergeSort(Pair[] pairs, Integer[] smaller) {
		int len = pairs.length;
		if (len <= 1)
			return pairs;

		Pair[] left = mergeSort(Arrays.copyOfRange(pairs, 0, len / 2), smaller);
		Pair[] right = mergeSort(Arrays.copyOfRange(pairs, len / 2, len), smaller);

		for (int i = 0, j = 0; i < left.length || j < right.length;) {
			if (j == right.length || i < left.length && left[i].val <= right[j].val) {
				pairs[i + j] = left[i];
				smaller[left[i].idx] += j;
				i++;
			} else {
				pairs[i + j] = right[j];
				j++;
			}
		}

		return pairs;
	}

}
