package hash_table;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public int solution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int count = 0;
		for (int i = 0, sum = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
