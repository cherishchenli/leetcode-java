package dynamic_programming;

public class HouseRobber {
	
	public int solution(int[] nums) {
        int max = 0, maxLast = 0;
        for (int num : nums) {
            int tmp = max;
            max = Math.max(maxLast + num, max);
            maxLast = tmp;
        }
        return Math.max(max, maxLast);
    }
	
}
