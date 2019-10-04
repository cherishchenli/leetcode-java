package sorting;

import java.util.*;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null)
				bucket[frequency] = new ArrayList<>();
			bucket[frequency].add(key);
		}

		for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
			if (bucket[i] != null)
				result.addAll(bucket[i]);
		}
		return result.subList(0, k);
	}

}
