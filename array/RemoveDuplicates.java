package array;

public class RemoveDuplicates {

	public int solution(int[] nums) {
		int i = 0, j = 0, n = nums.length;
		if (n == 0)
			return 0;
		while (j < n) {
			if (nums[j] != nums[i])
				nums[++i] = nums[j];
			j++;
		}
		return (i + 1);
	}

}
