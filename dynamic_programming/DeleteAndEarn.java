package dynamic_programming;

public class DeleteAndEarn {

	public int solution(int[] nums) {
		int n = 10001;
		int[] values = new int[n];
		for (int num : nums)
			values[num] += num;

		int prevYes = 0, prevNo = 0;
		for (int i = 0; i < n; i++) {
			int tmp = prevYes;
			prevYes = prevNo + values[i];
			prevNo = Math.max(tmp, prevNo);
		}

		return Math.max(prevYes, prevNo);
	}

}
