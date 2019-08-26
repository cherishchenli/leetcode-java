package array;

public class RemoveDuplicatesII {

	public int solution(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}

}
