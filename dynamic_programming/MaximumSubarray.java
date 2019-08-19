package dynamic_programming;

public class MaximumSubarray {
	
	public int solution(int[] nums) {
		int max = Integer.MIN_VALUE, prevMax = 0;
		for (int n : nums) {
			prevMax = n + (prevMax > 0 ? prevMax : 0);
			max = Math.max(max, prevMax);
		}
		return max;
	}
    
}
