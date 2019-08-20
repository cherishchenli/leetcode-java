package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
		Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i], j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1])
                        j++;
                    while (j < k && nums[k] == nums[k-1])
                        k--;
                    j++; k--;
                }
                else if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        
        return result;
    }
    
}
