package array;

public class FindDuplicateNumber {

	public int solution1(int[] nums) {
		// binary search
		int left = 1, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = 0;
			for (int n : nums) {
				if (n <= mid)
					count++;
			}
			if (count <= mid)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}

	public int solution2(int[] nums) {
		/* two pointers */
		int slow = nums[0], fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int p1 = nums[0];
		int p2 = slow;
		while (p1 != p2) {
			p1 = nums[p1];
			p2 = nums[p2];
		}

		return p1;
	}

}
