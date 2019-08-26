package dynamic_programming;

public class NumberOfLIS {

	public int solution(int[] nums) {
		int n = nums.length, result = 0, maxLen = 0;
		int[] len = new int[n], count = new int[n];

		for (int i = 0; i < n; i++) {
			len[i] = count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] <= nums[j])
					continue;
				if (len[i] == len[j] + 1)
					count[i] += count[j];
				else if (len[i] < len[j] + 1) {
					len[i] = len[j] + 1;
					count[i] = count[j];
				}
			}
			if (maxLen == len[i])
				result += count[i];
			else if (maxLen < len[i]) {
				maxLen = len[i];
				result = count[i];
			}
		}

		return result;
	}

}
