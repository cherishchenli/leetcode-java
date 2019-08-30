package greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoSubsequences {

	public boolean solution1(int[] nums) {
		// O(n) space
		// "appendfreq" stands for the "qualification" of current number to be appended
		// to a previous sequence
		Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();

		for (int num : nums)
			freq.put(num, freq.getOrDefault(num, 0) + 1);

		for (int num : nums) {
			if (freq.get(num) == 0)
				continue;
			// if the number can be appended to a previously constructed consecutive
			// sequence
			else if (appendfreq.getOrDefault(num, 0) > 0) {
				appendfreq.put(num, appendfreq.get(num) - 1);
				appendfreq.put(num + 1, appendfreq.getOrDefault(num + 1, 0) + 1);
			}
			// if the number can be the start of a new consecutive sequence
			else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
				freq.put(num + 1, freq.get(num + 1) - 1);
				freq.put(num + 2, freq.get(num + 2) - 1);
				appendfreq.put(num + 3, appendfreq.getOrDefault(num + 3, 0) + 1);
			} else
				return false;
			freq.put(num, freq.get(num) - 1);
		}
		return true;
	}

	public boolean solution2(int[] nums) {
		// O(1) space
		// p1, p2, p3: number of consecutive subsequences ending at prev with length of
		// 1, length of 2 and length >= 3
		// c1, c3, c3: number of consecutive subsequences ending at curr with length of
		// 1, length of 2 and length >= 3
		// cnt: number of appearance of curr
		int prev = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
		int curr = 0, cnt = 0, c1 = 0, c2 = 0, c3 = 0;

		for (int i = 0; i < nums.length; prev = curr, p1 = c1, p2 = c2, p3 = c3) {
			for (curr = nums[i], cnt = 0; i < nums.length && curr == nums[i]; cnt++, i++)
				;

			if (curr != prev + 1) {
				if (p1 != 0 || p2 != 0)
					return false;
				c1 = cnt;
				c2 = c3 = 0;
			} else {
				if (p1 + p2 > cnt)
					return false;
				c2 = p1;
				c3 = p2 + Math.min(p3, cnt - (p1 + p2));
				c1 = Math.max(0, cnt - (p1 + p2 + p3));
			}
		}

		return p1 == 0 && p2 == 0;
	}

}
