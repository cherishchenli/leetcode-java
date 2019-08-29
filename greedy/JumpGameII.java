package greedy;

public class JumpGameII {
	
    public int solution(int[] nums) {
        int max = 0, cnt = 0;
        for (int i = 0, j = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i >= j) {
                cnt++;
                j = max;
                if (max >= nums.length - 1)
                    return cnt;
            }
        }
        return cnt;
    }
    
}
