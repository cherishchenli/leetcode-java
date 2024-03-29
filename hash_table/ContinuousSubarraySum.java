package hash_table;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public boolean solution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0, sum = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0)
				sum %= k;
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1)
					return true;
			} else
				map.put(sum, i);
		}
		return false;
	}

}
