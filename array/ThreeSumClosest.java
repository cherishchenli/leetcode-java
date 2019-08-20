package array;

import java.util.Arrays;

public class ThreeSumClosest {
	
    public int solution(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE, result = 0, n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < minDiff) {
                    result = sum;
                    minDiff = Math.abs(sum - target);
                }
                if (sum == target)
                    return target;
                else if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        
        return result;
    }
    
}
