package dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int solution(int[] nums) {
		int n = nums.length, len = 0;
		int[] dp = new int[n];

		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0)
				i = -(i + 1);
			dp[i] = num;
			if (i == len)
				len++;
		}

		return len;
	}

}