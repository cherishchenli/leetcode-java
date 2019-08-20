package dynamic_programming;

public class HouseRobberII {
	
    public int solution(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
	private int rob(int[] nums, int start, int end) {
        int prevNo = 0, prevYes = 0;
        for (int i = start; i <= end; i++) {
            int tmp = prevYes;
            prevYes = Math.max(prevNo + nums[i], prevYes);
            prevNo = tmp;
        }
        return Math.max(prevNo, prevYes);
    }
}
