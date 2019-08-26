package array;

public class SortColors {

	public void solution(int[] nums) {
		for (int i = 0, c0 = 0, c1 = 0, c2 = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[c2++] = 2;
				nums[c1++] = 1;
				nums[c0++] = 0;
			} else if (nums[i] == 1) {
				nums[c2++] = 2;
				nums[c1++] = 1;
			} else if (nums[i] == 2)
				nums[c2++] = 2;
		}
	}

}
