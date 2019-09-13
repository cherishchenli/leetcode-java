package hash_table;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

	public int solution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int maxLen = 0;
		for (int i = 0, sum = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return maxLen;
	}

}
